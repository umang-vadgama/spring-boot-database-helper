package com.swt.database;


import com.swt.database.jdbctemplate.Student;
import com.swt.database.jdbctemplate.StudentJDBCTemplate;
import com.swt.database.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;

@SpringBootApplication
public class RunProcess  implements CommandLineRunner{

    @Autowired
    private Service usingJPA;

    @Autowired
    private StudentJDBCTemplate usingJdbcTemplate;

    @Autowired
    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        SpringApplication.run(RunProcess.class,args);


    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("  ********* USING JPA *********  ");
        usingJPA.insertIntoStudentEnrollUsingJPA();

        System.out.println("  ********* USING JDBC TEMPLATE *********  ");

        Student student = new Student();

        student.setfName("Jack");
        student.setlName("Jack");
        student.setDateOfBirth(Date.valueOf("1996-10-10"));
        student.setContactNumber("132131");
        student.setBranchId(7);

        Student student2 = new Student();

        student2.setfName("Kim");
        student2.setlName("Kim");
        student2.setDateOfBirth(Date.valueOf("1996-01-28"));
        student2.setContactNumber("132131454");
        student2.setBranchId(7);

        usingJdbcTemplate.insertIntoStudentEnroll(student);
        usingJdbcTemplate.insertIntoStudentEnroll(student2);

        usingJdbcTemplate.insertUsingPreparedStatementStudentEnroll(student);
        usingJdbcTemplate.insertUsingPreparedStatementStudentEnroll(student2);

        usingJdbcTemplate.initSimpleJdbcInsert();
        usingJdbcTemplate.insertUsingSimpleJDBCTemplateStudentEnroll(student);
        usingJdbcTemplate.insertUsingSimpleJDBCTemplateStudentEnroll(student2);
        usingJdbcTemplate.getAllStudentEnroll();


        //usingJdbcTemplate.updateStudentNameByIdInStudentEnroll(4,"Tom");
        //usingJdbcTemplate.deleteStudentInStudentEnroll(5);

        SpringApplication.exit(applicationContext);
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
