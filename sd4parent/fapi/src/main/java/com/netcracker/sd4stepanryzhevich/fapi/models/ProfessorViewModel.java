package com.netcracker.sd4stepanryzhevich.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProfessorViewModel {
    private int id_professor;
    private String firstname;
    private String secondname;
    private String patronymic;
    private String telnumber;
    private String email;

    public ProfessorViewModel(int id_professor, String firstname, String secondname, String patronymic, String telnumber, String email) {
        this.id_professor = id_professor;
        this.firstname = firstname;
        this.secondname = secondname;
        this.patronymic = patronymic;
        this.telnumber = telnumber;
        this.email = email;
    }

    public ProfessorViewModel(){}

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
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
