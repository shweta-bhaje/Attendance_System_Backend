/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.service;

import com.example.demo.entity.Attendance;
import com.example.demo.entity.Student;
import com.example.demo.repository.AttendanceRepository;
import com.example.demo.repository.StudentRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author chira
 */
@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository repository;
    @Autowired
    private StudentRepository stuRepository;
//      public Attendance punchIn(String name)
//    {
//        Attendance attendence=new Attendance();
//        attendence.setPunchInTime(LocalDateTime.now());
//        attendence.setDate(LocalDateTime.now());
//        attendence.setName(attendence.getName());
//        return repository.save(attendence);
//    }

    public Attendance punchIn(String name) {
        Student student = stuRepository.findByName(name);
        if (student != null) {
            Optional<Attendance> existingAttendance = repository.findByNameAndDate(name, LocalDate.now());
            if (existingAttendance.isPresent()) {
                System.out.println("You have already punched in today.");
                return null;  // or throw an exception if you want
            }
            Attendance attendance = new Attendance();
            attendance.setStudent(student);
            attendance.setPunchInTime(LocalDateTime.now());
            attendance.setStudentName(attendance.getStudentName());
            attendance.setDate(LocalDate.now());
            System.out.println("Punched in successfully");

            return repository.save(attendance);
        } else {
            System.out.println("there is no record found " + name);
        }
        return null;
    }

    public Attendance puchOut(String name) {
        Student student = stuRepository.findByName(name);
        if (student != null) {
            System.out.println("Student ID: " + student.getId());

            Optional<Attendance> op = repository.findByNameAndPunchOutTimeIsNull(student.getName());
            if (op.isPresent()) {
                Attendance get = op.get();
                get.setPunchOutTime(LocalDateTime.now());
                return repository.save(get);
            } else {
                System.out.println("No attendance record found for student with ID:" + student.getId());
            }
        } else {
            System.out.println("Student not found with name: " + name);

        }
        return null;
    }

    public Attendance punchOutTime(String name) {
        Optional<Attendance> op = repository.findByNameAndDate(name, LocalDate.now());
        if (op.isPresent()) {
            Attendance attendence = op.get();
             if (attendence.getPunchOutTime() != null) {
            System.out.println("You have already punched out today.");
            return null; // Return null or throw an exception, based on your use case
        }
            attendence.setPunchOutTime(LocalDateTime.now());
            return repository.save(attendence);
        } else {
            System.out.println("No punch-in record found for the student today.");

        }
        return null;
    }

    public List<Attendance> getAll() {
        return repository.findAll();
    }
    
    public Attendance getByID(int id)
    {
        Optional<Attendance> op = repository.findById(id);
        if(op.isPresent())
        {
            Attendance get = op.get();
            return get;
    }else{
            
            System.out.println("Record not found");
}
        return null;
}
}