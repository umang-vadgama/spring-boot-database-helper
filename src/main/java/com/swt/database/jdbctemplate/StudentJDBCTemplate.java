package com.swt.database.jdbctemplate;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class StudentJDBCTemplate {


    private JdbcTemplate jdbcTemplate;


    public StudentJDBCTemplate(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int insertIntoStudentEnroll(Student student){


        String sql = "insert into student801.student_enroll (student_fname ,student_lname ,contact_number ,date_of_birth ,branch_id ) \n" +
                "values (?,?,?,?,?)";

        int result = jdbcTemplate.update(sql,
                student.getfName(),
                student.getlName(),student.getContactNumber(),
                student.getDateOfBirth(),student.getBranchId());

        System.out.println("Inserted records into student_enroll : "+result);

        return result;
    }

    public List<Student> getAllStudentEnroll() {

        String sql = "select * from student_enroll";
        List<Student> students = jdbcTemplate.query(sql, new RowMapper<Student>() {
                    @Override
                    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {


                        Student student = new Student();
                        student.setsId(rs.getInt(1));
                        student.setfName(rs.getString(2));
                        student.setfName(rs.getString(3));
                        student.setContactNumber(rs.getString(4));
                        student.setBranchId(rs.getInt(5));
                        student.setDateOfBirth(rs.getDate(6));

                        return student;
                    }
                }
        );
        System.out.println("Get record from student_enroll "+students);
        return students;

    }

    public void updateStudentNameByIdInStudentEnroll(int id,String fName) {

        String sql = "update student_enroll set student_fname = ? where student_id = ?";
        int result = jdbcTemplate.update(sql, fName, id);

        System.out.println("Updated record in student_enroll "+result);

    }

    public int deleteStudentInStudentEnroll(int id){

        String sql = "delete from student_enroll where student_id =  ?";
        int result = jdbcTemplate.update(sql,id);
        System.out.println("Deleted record from student_enroll "+result);
        return result;
    }



}
