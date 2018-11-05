package com.netcracker.sd4stepanryzhevich.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FacultyViewModel {
    private long id_faculty;
    private String name;

    public FacultyViewModel(long id_faculty, String name) {
        this.id_faculty = id_faculty;
        this.name = name;
    }

    public FacultyViewModel(){}

    public long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(long id_faculty) {
        this.id_faculty = id_faculty;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
