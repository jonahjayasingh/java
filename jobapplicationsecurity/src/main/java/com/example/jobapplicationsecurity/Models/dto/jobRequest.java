package com.example.jobapplicationsecurity.Models.dto;

import java.util.List;


public record jobRequest(
    String jobName,
    String jobDescription,
    List<String> techs
) {
    
}
