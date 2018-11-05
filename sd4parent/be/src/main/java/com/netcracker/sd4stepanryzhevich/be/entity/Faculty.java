package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Faculty {
    private long id_faculty;
    private String name;

    @Id
    @Column(name = "id_faculty")
    public long getId_faculty() {
        return id_faculty;
    }

    public void setId_faculty(long idFaculty) {
        this.id_faculty = idFaculty;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Faculty faculty = (Faculty) o;

        if (id_faculty != faculty.id_faculty) return false;
        if (name != null ? !name.equals(faculty.name) : faculty.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_faculty ^ (id_faculty >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}
