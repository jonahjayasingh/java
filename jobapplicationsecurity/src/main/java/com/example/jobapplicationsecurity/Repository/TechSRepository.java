package com.example.jobapplicationsecurity.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.jobapplicationsecurity.Models.Techs;

public interface TechSRepository extends JpaRepository<Techs ,Integer> {
    
}
