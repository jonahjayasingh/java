package com.example.springbootorm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springbootorm.models.student;

@Repository
public interface StudentRepo extends JpaRepository<student,Integer> {

    // @Query("select s from student s where s.name = ?1")
    List<student> findByName(String name);
    
}
