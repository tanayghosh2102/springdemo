package com.may2020.crudDemo.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String fname;
    @NotNull
    private String lname;
    private String emailId;
    private Number salary;

    public Long getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmailId() {
        return emailId;
    }

    public Number getSalary() {
        return salary;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public void setSalary(Number salary) {
        this.salary = salary;
    }

}
