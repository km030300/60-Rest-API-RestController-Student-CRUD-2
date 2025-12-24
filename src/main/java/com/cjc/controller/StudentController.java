package com.cjc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cjc.Service.StudentService;
import com.cjc.model.Student;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentservice;
	
	@PostMapping(value = "/addstudent")
	public Student saveStaudent(@RequestBody Student stu) {
		
		Student saveStudnts = studentservice.saveStudnts(stu);
		return saveStudnts;
	}
	 @GetMapping(value = "/getstduent/{id}")
	 public Student getstudent(@PathVariable int id) {
		 
		 Student getstudent = studentservice.getStudent(id);
		 return getstudent;
	 }
	 
	 @GetMapping(value = "/getallstudent")
	 public List<Student> getallstudent(){
		 
		 List<Student> getallStudent = studentservice.getallStudent();
		 return getallStudent;
	 }
	 
	 @DeleteMapping(value = "/deletestudent/{id}")
	 public String deletestudent(@PathVariable int id ) {
		 
		 String deletestudent = studentservice.deletestudent(id);
		 return deletestudent;
		 
	 }
	 
	 @PutMapping(value = "/updatestudent/{id}")
	 public Student updatestudent(@PathVariable int id,@RequestBody Student stu ) {
		 
		 Student updatestudent = studentservice.updatestudent(id, stu);
		 return updatestudent;
		 
	 }
	 
	 @PatchMapping(value = "/fieldupdate/{id}")
	 public Student fieldupdate(@PathVariable int id, @RequestBody Student stu ) {
		Student editstu= studentservice.editfield(id, stu);
		 return editstu;
	 }

}
