package com.example.studentManagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.studentManagement.models.Student;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentManagementApplication.class, args);
		Student s= context.getBean(Student.class);
		s.setRollNo(101);
		s.setName("Navin");
		s.setMark(78);
		System.out.println(s.getMark());

	}

}
