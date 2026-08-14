package com.example.jobapplication.Models;

import java.util.List;

public class jobs {

    private String jobName;
    private String jobDescription;
    private List<String> tech;



    public String getJobName() {
        return jobName;
    }



    public void setJobName(String jobName) {
        this.jobName = jobName;
    }



    public String getJobDescription() {
        return jobDescription;
    }



    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }



    public List<String> getTech() {
        return tech;
    }



    public void setTech(List<String> tech) {
        this.tech = tech;
    }



    @Override
    public String toString(){
        return "Job [ job Name "+ jobName + "\nJob Descriptions"+ jobDescription +"\nTech" + tech +"]";
    }
    
}   
