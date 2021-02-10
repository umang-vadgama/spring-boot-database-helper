package com.swt.database.jdbctemplate;

import java.sql.Date;

public class Student {

    int sId;
    String fName,lName,contactNumber;
    Date dateOfBirth;
    int branchId;



    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getBranchId() {
        return branchId;
    }

    public void setBranchId(int branchId) {
        this.branchId = branchId;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId=" + sId +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", branchId=" + branchId +
                '}';
    }
}
