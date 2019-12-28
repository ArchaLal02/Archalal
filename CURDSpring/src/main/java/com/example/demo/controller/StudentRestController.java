package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;
import com.example.demo.respository.StudentRepo;

@RestController
public class StudentRestController {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("students")
	public List<Student> studentpage() {
		return repo.findAll();
		
		
	}
	@PostMapping("students")
	public Boolean insertdata(@RequestBody Student student) {
		try {
			repo.save(student);
		}catch(IllegalArgumentException  e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
	@DeleteMapping("students/{id}")
	public List<Student> deletedata(@PathVariable("id") int id,Student student) {
		return repo.findAll();
		
	}
	
	@PutMapping("students/{id}")
	public void putdata(@PathVariable("id") int id,Model model) {
		
	}

}
