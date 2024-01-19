package org.example.job.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;

@Entity
@Table(name = "jobs")
@Data
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "job_page_url", nullable = false, unique = true)
    private String jobPageUrl;

    @Column(name = "position_name", nullable = false)
    private String positionName;

    @Column(name = "url_to_organization", nullable = false)
    private String urlToOrganization;

    @Column(name = "logo", nullable = false)
    private String logo;

    @Column(name = "organization_title", nullable = false)
    private String organizationTitle;

    @Column(name = "labor_function", nullable = false)
    private String laborFunction;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "posted_date", nullable = false)
    private String postedDate;

    @Column(name = "description", nullable = false, columnDefinition = "TEXT")
    private String description;

    @Column(name = "tags_names", nullable = false)
    private String tagsNames;
}
