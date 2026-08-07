
package com.example.studentmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.studentmanagement.Repo.studentRepo;
import com.example.studentmanagement.models.Student;

@Service
public class StudentService {

    @Autowired
    private studentRepo repo;
    
    public studentRepo getRepo() {
        return repo;
    }

    public void setRepo(studentRepo repo) {
        this.repo = repo;
    }

    public void addStudent(Student s){
        repo.save(s);
    }

    public List<Student> getStudents() {
        return  repo.findAll();
    }
}
