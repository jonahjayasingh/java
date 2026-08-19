package com.example.springbootrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbootrest.model.JobPost;
import com.example.springbootrest.service.JobService;

@RestController
// @CrossOrigin(origins = "")
public class JobRestController {
    
    @Autowired
    private JobService jobService;


    @GetMapping("jobPost")
    public List<JobPost> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("jobPost/{id}")
    public JobPost getJobPost(@PathVariable int id){
        return jobService.getJopbPost(id);
    }

    @PostMapping("jobPost")
    public void addJob(@RequestBody JobPost jobPost){
        jobService.addJobPost(jobPost);
    }

    @PutMapping("jobPost")
    public JobPost updateJobPost(@RequestBody JobPost jobPost){
        jobService.updateJobPost(jobPost);
        return jobService.getJopbPost(jobPost.getPostId());
    }

    @DeleteMapping("jobPost/{id}")
    public String deleteJobPost(@PathVariable int id){
        jobService.deleteJobPost(id);
        return "Deleted Succusfully";
    }
    
}
