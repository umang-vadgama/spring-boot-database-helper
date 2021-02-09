package com.swt.database.jpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Dept {



    @Id
    @Column(name = "branch_code")
    private BigDecimal branchCode;


    private String branchName;


    @OneToMany(targetEntity=StudentEnroll.class, mappedBy="branchId",cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<StudentEnroll> studentEnrolls;


    public Dept(){}

    public Dept(BigDecimal branchCode,String branchName){
        this.branchCode=branchCode;
        this.branchName=branchName;

    }


    public BigDecimal getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(BigDecimal branchCode) {
        this.branchCode = branchCode;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public List<StudentEnroll> getStudentEnrolls() {
        return studentEnrolls;
    }

    public void setStudentEnrolls(List<StudentEnroll> studentEnrolls) {
        this.studentEnrolls = studentEnrolls;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "branchCode=" + branchCode +
                ", branchName='" + branchName + '\'' +
                '}';
    }
}
