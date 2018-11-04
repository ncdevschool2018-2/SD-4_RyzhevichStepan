package com.netcracker.sd4stepanryzhevich.fapi.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentsGroupViewModel {
    private long id_group;
    private String name;
    private long id_faculty;

    public StudentsGroupViewModel(long id_group, String name, long id_faculty) {
        this.id_group = id_group;
        this.name = name;
        this.id_faculty = id_faculty;
    }

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

    public long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(long id_faculty) {
        this.id_faculty = id_faculty;
    }
}
