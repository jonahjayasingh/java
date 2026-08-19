package com.example.springbootorm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springbootorm.models.student;


@SpringBootApplication
public class SpringbootormApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(SpringbootormApplication.class, args);

		StudentRepo repo = context.getBean(StudentRepo.class);

		student s1 = context.getBean(student.class);
		student s2 = context.getBean(student.class);

		s1.setRollNo(1);
		s1.setName("Jonah");
		s1.setMark(100);

		s2.setRollNo(2);
		s2.setName("John");
		s2.setMark(90);

		// repo.save(s1);
		// repo.save(s2);
		System.out.println(repo.findAll());
		System.out.println(repo.findById(1));
		System.out.println(repo.findByName("John"));
	}
}