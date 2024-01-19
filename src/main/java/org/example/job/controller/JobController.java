package org.example.job.controller;

import org.example.job.service.JobService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/main")
    public String main(
            @RequestParam(required = false, defaultValue = "") String function
    ){
        jobService.parsePage("https://jobs.techstars.com/jobs?filter=eyJqb2JfZnVuY3Rpb25zIjpbIklUIl19");

        return "main";
    }

}
