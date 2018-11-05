package com.netcracker.sd4stepanryzhevich.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentsGroupViewModel {
    private long id_group;
    private String name;
    private FacultyViewModel faculty;
    private int course;

    public StudentsGroupViewModel(long id_group, String name, FacultyViewModel faculty, int course) {
        this.id_group = id_group;
        this.name = name;
        this.faculty = faculty;
        this.course = course;
    }

    public StudentsGroupViewModel(){}

    public long getId_group() {
        return id_group;
    }

    public void setId_group(long id_group) {
        this.id_group = id_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FacultyViewModel getFaculty() {
        return faculty;
    }

    public void setFaculty(FacultyViewModel faculty) {
        this.faculty = faculty;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}
