/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chira
 */
@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public List<Student> getAll() {
        return repository.findAll();
    }

    public Student SaveAll(Student student) {
        return repository.save(student);
    }

    public Student findById(int id) {
        Optional<Student> op = repository.findById(id);
        if (op.isPresent()) {
            Student get = op.get();
            return get;
        }
        return null;
    }
    
     public Student updateRecord(Student student, int id)
    {
        Student getId = findById(id);
        if(getId!=null)
        {
            getId.setName(student.getName());
            getId.setCourse(student.getCourse());
            getId.setEmail(student.getEmail());
            getId.setPassword(student.getPassword());
            getId.setPassword(student.getPassword());
            getId.setContact(student.getContact());
            getId.setRollNo(student.getRollNo());
            repository.save(getId);
        }
        return getId;
    }
      public Student deleteRecord(int  id)
    {
        Student delete = findById(id);
        if(delete!=null)
        {
            repository.deleteById(id);
        }
        return delete;
    }
}
