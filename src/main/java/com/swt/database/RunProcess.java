package com.swt.database;


import com.swt.database.jpa.Dept;
import com.swt.database.jpa.DeptRepository;
import com.swt.database.jpa.StudentEnroll;
import com.swt.database.jpa.StudentRepository;
import com.swt.database.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;
import java.sql.Date;

import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.List;

@SpringBootApplication
public class RunProcess  implements CommandLineRunner{

    @Autowired
    private Service service;

    public static void main(String[] args) {
        SpringApplication.run(RunProcess.class,args);


    }

    @Override
    public void run(String... args) throws Exception {
        service.run();
    }


    /*@Bean
    public CommandLineRunner demo(StudentRepository studentRepository, DeptRepository deptRepository){

        return (args) ->{






            Dept computerEngg = deptRepository.findByBranchCode(new BigDecimal("7"));


            List<StudentEnroll> addStudent = new ArrayList<>();

            addStudent.add(new StudentEnroll(new BigDecimal("4"),
                    "Raj","Sharma","1234567899", Date.valueOf("1998-03-31"),computerEngg));

            addStudent.add(new StudentEnroll(new BigDecimal("5"),
                    "Keyur","Sharma","45454545544",Date.valueOf("1999-05-28"),computerEngg));

            studentRepository.saveAll(addStudent);


            List<StudentEnroll> students = studentRepository.findAll();

            students.forEach(System.out::println);

            List<Dept> allDept = deptRepository.findAll();

            allDept.forEach(System.out::println);

        };


    }*/

}
