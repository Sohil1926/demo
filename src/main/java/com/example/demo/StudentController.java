package com.example.demo;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

	@Autowired
	public StudentService studentService;
	
	@PostMapping("/student")
	public int addStudent(@Valid @RequestBody Student student) {
	student = new Student("John", "Smith");
	return studentService.addStudent(student);
	}
	
}
