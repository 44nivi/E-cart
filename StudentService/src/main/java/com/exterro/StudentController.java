package com.exterro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
@CrossOrigin("http://localhost:4200/")
public class StudentController {
	@Autowired
	private StudentRepo srepo;
	
	@PostMapping("addStudent")
	public ResponseEntity<?> addStudent(@RequestBody Student stud){
		return ResponseEntity.ok(srepo.save(stud));
	}
	
	@GetMapping
	public ResponseEntity<?> getAll(){
		return ResponseEntity.ok(srepo.findAll());
	}
}
