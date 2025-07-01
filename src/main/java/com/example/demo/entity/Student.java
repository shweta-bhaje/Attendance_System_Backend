/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@JsonIgnoreProperties({"attendances"})  // Ignore the 'attendances' property when serializing
@JsonInclude(JsonInclude.Include.NON_NULL)

public class Student {

    @Id
    @GeneratedValue
    private int id;
        @JsonManagedReference
//        @JsonIgnore

    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Attendance> attendances;
    private String name;
    private String course;
    private String email;
    private String password;
    private Long contact;
    private String rollNo;
}
