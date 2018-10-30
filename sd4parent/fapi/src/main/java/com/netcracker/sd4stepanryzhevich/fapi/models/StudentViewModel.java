package com.netcracker.sd4stepanryzhevich.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentViewModel {
    private int id_student;
    private String firstname;
    private String secondname;
    private String patronymic;
    private int id_group;
    private int subgroup;
    private String telnumber;
    private String email;
    private int course;


    public StudentViewModel(int id_student, String firstname, String secondname, String patronymic, int id_group, int subgroup, String telnumber, String email, int course) {
        this.id_student = id_student;
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.id_group = id_group;
        this.subgroup = subgroup;
        this.telnumber = telnumber;
        this.email = email;
        this.course = course;
    }

    public StudentViewModel(){}

    public int getId_student() {
        return id_student;
    }

    public void setId_student(int id_student) {
        this.id_student = id_student;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(int subgroup) {
        this.subgroup = subgroup;
    }

    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
