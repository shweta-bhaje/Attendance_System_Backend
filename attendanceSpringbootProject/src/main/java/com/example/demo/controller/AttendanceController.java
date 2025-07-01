/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.controller;

import com.example.demo.entity.Attendance;
import com.example.demo.service.AttendanceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chira
 */
//@CrossOrigin(origins = "*")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    private AttendanceService service;
    
    @PostMapping("/{name}")
    public  Attendance puncInTime(@PathVariable String name)
    {
        Attendance punchIn = service.punchIn(name);
        return punchIn;
    }
   
     @PostMapping("out/{name}")
    public  Attendance puncOutTime(@PathVariable String name)
    {
        Attendance punchOut = service.puchOut(name);
        return punchOut;
    }
     
    @PostMapping("outtime/{name}")
    public  Attendance puncOut(@PathVariable String name)
    {
        Attendance punchOut = service.punchOutTime(name);
        return punchOut;
    }
    @GetMapping
    public List<Attendance> getAllRecord()
    {
       return service.getAll();
    }
    @GetMapping("get/{id}")
    public Attendance getId(@PathVariable int id)
    {
       return service.getByID(id);
    }
   
}
