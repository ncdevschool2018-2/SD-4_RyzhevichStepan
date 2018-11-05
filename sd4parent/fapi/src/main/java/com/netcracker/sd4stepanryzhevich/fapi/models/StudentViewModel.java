package com.netcracker.sd4stepanryzhevich.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentViewModel {
    private long id_student;
    private String firstname;
    private String secondname;
    private String patronymic;
    private int subgroup;
    private String telnumber;
    private String email;
    private StudentsGroupViewModel group;

    public StudentViewModel(long id_student, String firstname, String secondname, String patronymic, int subgroup,
                            String telnumber, String email, StudentsGroupViewModel group) {
        this.id_student = id_student;
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.subgroup = subgroup;
        this.telnumber = telnumber;
        this.email = email;
        this.group = group;
    }

    public StudentViewModel(){}

    public StudentsGroupViewModel getGroup() {
        return group;
    }

    public void setGroup(StudentsGroupViewModel group) {
        this.group = group;
    }

    public long getId_student() {
        return id_student;
    }

    public void setId_student(long id_student) {
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
}
