package com.school.teacher_ms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TeacherMsApplication {

	public static void main(String[] args) {

		System.out.println("Hello from Teacher!");
		SpringApplication.run(TeacherMsApplication.class, args);
	}

}
