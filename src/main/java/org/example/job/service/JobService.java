package org.example.job.service;

import org.example.job.entity.Job;
import org.example.job.repos.JobRepository;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class JobService {

    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public void parsePage(String url) {
        try {
            Job job = new Job();
            Document doc = Jsoup.connect(url).get();
            Document docDetail;

            Elements jobPosts = doc.select("a[data-testid=job-title-link]");


            for (Element jobPost : jobPosts) {
                String href = jobPost.attr("href");
                if (href.startsWith("/")) {
                    job.setJobPageUrl("https://jobs.techstars.com" + href);
                    docDetail = Jsoup.connect("https://jobs.techstars.com" + href).get();
                    System.out.println("https://jobs.techstars.com" + href);
                } else {
                    job.setJobPageUrl(href);
                    try {
                        docDetail = Jsoup.connect(href).get();
                    }catch (HttpStatusException exception){
                        System.out.println("Not connected!");
                        docDetail = null;
                    }
                    System.out.println(href);
                }


                try {
                    String positionName = docDetail.getElementsByTag("h2").first().text();
                    System.out.println(positionName);
                } catch (NullPointerException e) {
                    System.out.println("NotFound!");
                }


/*
                job.setPositionName(jobPost.select("").text());
                job.setUrlToOrganization(jobPost.select("").text());
                job.setLogo(jobPost.select("").text());
                job.setOrganizationTitle(jobPost.select("").text());
                job.setLaborFunction(jobPost.select("").text());
                job.setLocation(jobPost.select("").text());
                job.setPostedDate(jobPost.select("").text());
                job.setDescription(jobPost.select("").text());
                job.setTagsNames(jobPost.select("").text());


                jobRepository.save(job);
            }*/

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}