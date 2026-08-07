package com.example.studentmanagement;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.studentmanagement.Service.StudentService;
import com.example.studentmanagement.models.Student;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StudentManagementApplication.class, args);
		Student s= context.getBean(Student.class);
		s.setRollNo(101);
		s.setName("Navin");
		s.setMark(78);
		System.out.println(s.getMark());

		StudentService service = context.getBean(StudentService.class);
		service.addStudent(s);

		List<Student> students = service.getStudents();
		System.out.println(students);
	}

}
