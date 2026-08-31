package com.example.jobapplicationsecurity.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


import com.example.jobapplicationsecurity.Models.jobs;
import com.example.jobapplicationsecurity.Models.dto.jobRequest;
import com.example.jobapplicationsecurity.Services.websiteSevice;

import jakarta.websocket.server.PathParam;

import org.springframework.ui.Model;

@Controller
public class websitecontroller {
    @Autowired 
    private websiteSevice webserv;

    @RequestMapping("/")
    public String Home(){
        return "home";
    }

    @RequestMapping("/joblist")
    public String JobList(Model model){
        List<jobs> jobs = webserv.getJobs();
        model.addAttribute("jobs",jobs);
        return "Joblist";
    }

    @GetMapping("/addjob")
   public String AddJob(){
        return "addjob";
    }
    
    @PostMapping("/addjob")
    public String SaveJob(@ModelAttribute jobRequest job,Model model){

        webserv.addjob(job);
        return "addjob";
    }

    @PutMapping("update")
    public jobs updateJobs(@RequestBody jobs job){
        return webserv.updateJobs(job);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deletejob(@PathVariable int id){

        Optional<jobs> job = webserv.findJobsById(id);

        if (job.isPresent()){
            webserv.deleteJob(id);
            return ResponseEntity.ok("Job delete Successfully");
        }

        return ResponseEntity.notFound().build();

    }


}
