/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author chira
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Attendance {
//        @JsonBackReference
    @ManyToOne
        @JsonBackReference  // Prevents recursion during serialization
    @JoinColumn(name = "student_id")
    private Student student;
    @Id
    @GeneratedValue
    private int id;
    private LocalDateTime punchInTime;
    private LocalDateTime punchOutTime;
    private LocalDate date;
    private String name;
//    private int rollNo;
    @JsonProperty("student_name")  // You can name this whatever you want in the output JSON
    public String getStudentName() {
        return student != null ? student.getName() : null;
    }
     public void setStudentName(String name) {
        this.name = name;
    }


}
