package com.example.jobapplication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.jobapplication.Models.jobs;
import com.example.jobapplication.Services.websiteSevice;

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
    public String SaveJob(@ModelAttribute jobs job,Model model){
        System.out.println(job);
        webserv.addjob(job);
        return "addjob";
    }
    
}
