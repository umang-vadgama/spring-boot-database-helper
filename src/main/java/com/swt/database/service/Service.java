package com.swt.database.service;

import com.swt.database.jpa.Dept;
import com.swt.database.jpa.DeptRepository;
import com.swt.database.jpa.StudentEnroll;
import com.swt.database.jpa.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


@org.springframework.stereotype.Service
public class Service {


    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DeptRepository deptRepository;

    public void insertIntoStudentEnrollUsingJPA(){

        Dept computerEngg = deptRepository.findByBranchCode(new BigDecimal("7"));


        List<StudentEnroll> addStudent = new ArrayList<>();

        addStudent.add(new StudentEnroll(new BigDecimal("4"),
                "Raj","Sharma","1234567899", Date.valueOf("1998-03-31"),computerEngg));

        addStudent.add(new StudentEnroll(new BigDecimal("5"),
                "Keyur","Sharma","45454545544",Date.valueOf("1999-05-28"),computerEngg));

        studentRepository.saveAll(addStudent);


        List<StudentEnroll> students = studentRepository.findAll();


        System.out.println("ALL STUDENTS : \n"+students);

        List<Dept> allDept = deptRepository.findAll();


        System.out.println("ALL DEPT : \n"+allDept);


    }


}
