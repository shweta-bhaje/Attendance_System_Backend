/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import java.util.List;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chira
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;
    @Autowired
    private StudentRepository repository;
    @GetMapping
    public List<Student> getAll() {
        return service.getAll();
    }
    
    @PostMapping
    public Student saveAll(@RequestBody Student student) {
        return service.SaveAll(student);
    }
     @PutMapping("/put/{id}")
    public Student updateAll(@RequestBody Student student, @PathVariable int id) {
        return service.updateRecord(student, id);
    }
 
    @GetMapping("/get/{id}")
    public Student findById(@PathVariable int id) {
        return service.findById(id);
    }
    
     @DeleteMapping("/delete/{id}")
    public Student deleteRecord(@PathVariable int id) {
        return service.deleteRecord(id);
    }
    
    @PostMapping("/login")
    public String login(@RequestBody Student student) {
        Student foundStudent = repository.findByName(student.getName());

        if (foundStudent == null) {
            System.out.println("NO recordfound");
            return "{\"message\":\"Student not found or invalid credentials\"}";
        }
        if (foundStudent.getPassword().equals(student.getPassword())) {

            System.out.println("LOg in Successfull");
            return "{\"message\":\"Login Successful\"}";
        } else {
            System.out.println("LOg in failed");
            return "{\"message\":\"Login Failed\"}";
        }
    }
    
    @PostMapping("/log")
       public Object loginStudent(@RequestBody Student student) {
        Student s = repository.findByName(student.getName());
        // Check if student exists and password matches
        if (s != null && s.getPassword().equals(student.getPassword())) {
            return s;
        } else {
            System.out.println("Login Failed");
           return null;
        }
       
    }
}
