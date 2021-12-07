package com.swt.database.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class StudentJDBCTemplate {


    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert messageInsert;

    public StudentJDBCTemplate(DataSource dataSource) {

        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.messageInsert = new SimpleJdbcInsert(dataSource);

    }

    public int insertIntoStudentEnroll(Student student){

        String sql = "insert into student801.student_enroll (student_fname ,student_lname ,contact_number ,date_of_birth ,branch_id ) \n" +
                "values (?,?,?,?,?)";

        int result = jdbcTemplate.update(sql,
                student.getfName(),
                student.getlName(),student.getContactNumber(),
                student.getDateOfBirth(),student.getBranchId());

        System.out.println("*********************");
        System.out.println("Inserted using JDBC Template into student_enroll : "+result);
        System.out.println("*********************");

        return result;

    }

    public int insertUsingPreparedStatementStudentEnroll(Student student){


        String sql = "insert into student801.student_enroll (student_fname ,student_lname ,contact_number ,date_of_birth ,branch_id ) \n" +
                "values (?,?,?,?,?)";

        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(sql,new String[] {"student_id"});
            ps.setString(1, student.getfName());
            ps.setString(2, student.lName);
            ps.setString(3,student.getContactNumber());
            ps.setDate(4,student.getDateOfBirth());
            ps.setInt(5,student.getBranchId());
            return ps;
        }, keyHolder);

        int result = keyHolder.getKey().intValue() ;

        System.out.println("*********************");
        System.out.println("Inserted records using prepared statement into student_enroll : "+result);
        System.out.println("*********************");

        return result;
    }

    public void initSimpleJdbcInsert(){

        messageInsert.withTableName("student_enroll").usingGeneratedKeyColumns("student_id");

    }

    public int insertUsingSimpleJDBCTemplateStudentEnroll(Student student) {

        Map<String, Object> parameters = new HashMap<>(5);
        parameters.put("student_fname", student.getfName());
        parameters.put("student_lname", student.getlName());
        parameters.put("contact_number", student.getContactNumber());
        parameters.put("date_of_birth", student.getDateOfBirth());
        parameters.put("branch_id", student.getBranchId());
        Number result = messageInsert.executeAndReturnKey(parameters);

        System.out.println("*********************");
        System.out.println("Inserted records using using simple JDBC  template into student_enroll : "+result);
        System.out.println("*********************");

        return result.intValue();
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
