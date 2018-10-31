package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Professor {
    private long idProfessor;
    private String firstname;
    private String secondname;
    private String patronymic;
    private String telnumber;
    private String email;

    @Id
    @Column(name = "id_professor")
    public long getIdProfessor() {
        return idProfessor;
    }

    public void setIdProfessor(long idProfessor) {
        this.idProfessor = idProfessor;
    }

    @Basic
    @Column(name = "firstname")
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "secondname")
    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Basic
    @Column(name = "patronymic")
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "telnumber")
    public String getTelnumber() {
        return telnumber;
    }

    public void setTelnumber(String telnumber) {
        this.telnumber = telnumber;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Professor professor = (Professor) o;

        if (idProfessor != professor.idProfessor) return false;
        if (firstname != null ? !firstname.equals(professor.firstname) : professor.firstname != null) return false;
        if (secondname != null ? !secondname.equals(professor.secondname) : professor.secondname != null) return false;
        if (patronymic != null ? !patronymic.equals(professor.patronymic) : professor.patronymic != null) return false;
        if (telnumber != null ? !telnumber.equals(professor.telnumber) : professor.telnumber != null) return false;
        if (email != null ? !email.equals(professor.email) : professor.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idProfessor ^ (idProfessor >>> 32));
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (telnumber != null ? telnumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
