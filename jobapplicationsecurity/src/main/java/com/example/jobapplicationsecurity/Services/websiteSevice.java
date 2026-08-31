package com.example.jobapplicationsecurity.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.jobapplicationsecurity.Models.jobs;
import com.example.jobapplicationsecurity.Models.dto.jobRequest;
import com.example.jobapplicationsecurity.Repository.JobRepository;
import com.example.jobapplicationsecurity.Repository.TechSRepository;

@Service
public class websiteSevice {
    
    @Autowired
    private JobRepository jobrepo;
    @Autowired
    private TechSRepository techrepo;

    public void addjob(jobRequest job){
        System.err.println(job.techs());
        // jobrepo.save(job);
    }

    public List<jobs> getJobs(){
        return jobrepo.findAll();
    }

    
    public jobs updateJobs(jobs job){
        return jobrepo.save(job);
    }

    public Optional<jobs> findJobsById(int id){
        return jobrepo.findById(id);
    }

    public void deleteJob(int id){
        jobrepo.deleteById(id);
    }

}
