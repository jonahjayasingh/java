package com.example.jobapplication.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.jobapplication.Models.jobs;
import com.example.jobapplication.Repository.websiteRepository;

@Service
public class websiteSevice {
    
    @Autowired
    private websiteRepository webrepo;

    public void addjob(jobs job){
        webrepo.save(job);
    }

    public List<jobs> getJobs(){
        return webrepo.findAll();
    }


}
