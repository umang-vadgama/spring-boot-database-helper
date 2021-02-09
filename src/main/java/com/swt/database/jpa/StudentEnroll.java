package com.swt.database.jpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;


@Entity
@Table(name = "student_enroll")
public class StudentEnroll {



    @Id
    public BigDecimal studentId;

    public String studentFname;
    public String studentLname;
    public String contactNumber;


    private Date dateOfBirth;

    /*@OneToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "branch_id", nullable = false)
    private Dept branchId;*/

    @ManyToOne()
    @JoinColumn(name="branch_id")
    private Dept branchId;

    public StudentEnroll(){}

    public StudentEnroll(BigDecimal studentId, String studentFname, String studentLname, String contactNumber, Date dateOfBirth, Dept branchId){

        this.studentId=studentId;
        this.studentFname=studentFname;
        this.studentLname=studentLname;
        this.contactNumber=contactNumber;
        this.dateOfBirth = dateOfBirth;
        this.branchId=branchId;

    }

    public BigDecimal getStudentId() {
        return studentId;
    }

    public void setStudentId(BigDecimal studentId) {
        this.studentId = studentId;
    }

    public String getStudentFname() {
        return studentFname;
    }

    public void setStudentFname(String studentFname) {
        this.studentFname = studentFname;
    }

    public String getStudentLname() {
        return studentLname;
    }

    public void setStudentLname(String studentLname) {
        this.studentLname = studentLname;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Dept getBranchId() {
        return branchId;
    }

    public void setBranchId(Dept branchId) {
        this.branchId = branchId;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        return "StudentEnroll{" +
                "studentId=" + studentId +
                ", studentFname='" + studentFname + '\'' +
                ", studentLname='" + studentLname + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", branchId=" + branchId +
                '}';
    }
}
