package com.example.jobapplicationsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jobapplicationsecurity.Models.jobs;



@Repository
public interface JobRepository extends JpaRepository<jobs,Integer> {

    
}
