/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.demo.repository;

import com.example.demo.entity.Attendance;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author chira
 */
@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Integer>{
        Optional<Attendance> findByNameAndDate(String name,LocalDate date);
    Optional<Attendance> findByNameAndPunchOutTimeIsNull(String name);
}
