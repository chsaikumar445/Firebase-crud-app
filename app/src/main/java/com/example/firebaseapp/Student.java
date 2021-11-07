package com.example.firebaseapp;

import java.io.Serializable;

public class Student
{
    private String name;
    private  String id;
    private String salary;
    private String phone;
    private String email;
    private String location;

    public Student(){

    }

    public Student(String name, String id, String salary, String phone, String email, String location) {
        this.name = name;
        this.id = id;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.location = location;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}