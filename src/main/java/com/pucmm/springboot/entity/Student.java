package com.pucmm.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
    @Id
    private int idStudent;
    private String name;
    private String lastName;
    private String phone;

    public Student(){
        super();
    }

    public Student(int idStudent, String name, String lastName, String phone) {
        this.idStudent = idStudent;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
    }


    public int getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(int idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
