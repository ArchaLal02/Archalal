package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.example.demo.bean.Student;

import com.example.demo.respository.StudentRepo;

@Controller
public class ControllerSpring {
	
	@Autowired
	private StudentRepo repo;
	
	@GetMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@GetMapping("insert")
	public  String insert() {
		return "insert";
	}
	
	@GetMapping("edit")
	public  String update() {
		
		return "update";
	}
	

	@PostMapping("insertaction")
	public String insertDetails(Student student){
		repo.save(student);
		System.out.println(student.getName());
		System.out.println(student.getAddress());
		return "home";
	}
	
	@PostMapping("updatedata")
	public String updateData(Student student){
		repo.save(student);
		
		return "home";
	}
	
	@GetMapping("view")
	public String view(Model model) {
		List<Student> studentlist=new ArrayList<Student>();
		studentlist=repo.findAll();
		model.addAttribute("studentlist",studentlist);
		return "view";
		
	}
	
	@GetMapping("deletedata")
    public String deleteData(Model model,Student student) {
		List<Student> studentlist=new ArrayList<Student>();
        repo.delete(student);
        studentlist=repo.findAll();
		model.addAttribute("studentlist",studentlist);
        return "view";
    }
	@GetMapping("updatedata")
    public String updateData(Model model,Student student) {
		List<Student> studentlist=new ArrayList<Student>();
        repo.save(student);
        studentlist=repo.findAll();
		model.addAttribute("studentlist",studentlist);
        return "view";
    }
    
	
	
	

}
