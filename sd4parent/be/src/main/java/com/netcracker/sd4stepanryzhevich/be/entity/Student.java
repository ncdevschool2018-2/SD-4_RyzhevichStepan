package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
public class Student {
    private long id_student;
    private String firstname;
    private String secondname;
    private String patronymic;
    private int id_group;
    private String telnumber;
    private String email;
    private int course;
    private int subgroup;

    @Id
    @Column(name = "id_student", nullable = false)
    public long getId_student() {
        return id_student;
    }

    public void setId_student(long id_student) {
        this.id_student = id_student;
    }

    @Basic
    @Column(name = "firstname", length = 45)
    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    @Basic
    @Column(name = "secondname", length = 45)
    public String getSecondname() {
        return secondname;
    }


    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Basic
    @Column(name = "patronymic", length = 45)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Basic
    @Column(name = "id_group")
    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
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
    @Column(name = "email", length = 45)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "course")
    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    @Basic
    @Column(name = "subgroup")
    public int getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(int subgroup) {
        this.subgroup = subgroup;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id_student=" + id_student +
                ", firstname='" + firstname + '\'' +
                ", secondname='" + secondname + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", id_group=" + id_group +
                ", telnumber='" + telnumber + '\'' +
                ", email='" + email + '\'' +
                ", course=" + course +
                ", subgroup=" + subgroup +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return id_student == that.id_student &&
                id_group == that.id_group &&
                course == that.course &&
                subgroup == that.subgroup &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(secondname, that.secondname) &&
                Objects.equals(patronymic, that.patronymic) &&
                Objects.equals(telnumber, that.telnumber) &&
                Objects.equals(email, that.email);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_student, firstname, secondname, patronymic, id_group, telnumber, email, course, subgroup);
    }

    //    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private long id_student;
//    private String firstname;
//    private String secondname;
//    private String patronymic;
//    private int id_group;
//    private String telnumber;
//    private String email;
//    private int course;
//    private int subgroup;
//
//    public Student(long id_student, String firstname, String secondname, String patronymic, int id_group, int subgroup, String telnumber, String email, int course) {
//        this.id_student = id_student;
//        this.firstname = firstname;
//        this.secondname = secondname;
//        this.patronymic = patronymic;
//        this.id_group = id_group;
//        this.telnumber = telnumber;
//        this.email = email;
//        this.course = course;
//        this.subgroup = subgroup;
//
//    }
//    public Student(){}
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student that = (Student) o;
//        return id_student == that.id_student &&
//                id_group == that.id_group &&
//                course == that.course &&
//                subgroup == that.subgroup &&
//                Objects.equals(firstname, that.firstname) &&
//                Objects.equals(secondname, that.secondname) &&
//                Objects.equals(patronymic, that.patronymic) &&
//                Objects.equals(telnumber, that.telnumber) &&
//                Objects.equals(email, that.email);
//    }
//
//    @Override
//    public int hashCode() {
//
//        return Objects.hash(id_student, firstname, secondname, patronymic, id_group, telnumber, email, course, subgroup);
//    }
//
//    @Override
//    public String toString() {
//        return "Student{" +
//                "id_student=" + id_student +
//                ", firstname='" + firstname + '\'' +
//                ", secondname='" + secondname + '\'' +
//                ", patronymic='" + patronymic + '\'' +
//                ", id_group=" + id_group +
//                ", telnumber='" + telnumber + '\'' +
//                ", email='" + email + '\'' +
//                ", course=" + course +
//                ", subgroup=" + subgroup +
//                '}';
//    }
//
//    public long getId_student() {
//        return id_student;
//    }
//
//    public void setId_student(long id_student) {
//        this.id_student = id_student;
//    }
//
//    public String getFirstname() {
//        return firstname;
//    }
//
//    public void setFirstname(String firstname) {
//        this.firstname = firstname;
//    }
//
//    public String getSecondname() {
//        return secondname;
//    }
//
//    public void setSecondname(String secondname) {
//        this.secondname = secondname;
//    }
//
//    public String getPatronymic() {
//        return patronymic;
//    }
//
//    public void setPatronymic(String patronymic) {
//        this.patronymic = patronymic;
//    }
//
//    public int getId_group() {
//        return id_group;
//    }
//
//    public void setId_group(int id_group) {
//        this.id_group = id_group;
//    }
//
//    public int getSubgroup() {
//        return subgroup;
//    }
//
//    public void setSubgroup(int subgroup) {
//        this.subgroup = subgroup;
//    }
//
//    public String getTelnumber() {
//        return telnumber;
//    }
//
//    public void setTelnumber(String telnumber) {
//        this.telnumber = telnumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public int getCourse() {
//        return course;
//    }
//
//    public void setCourse(int course) {
//        this.course = course;
//    }
}