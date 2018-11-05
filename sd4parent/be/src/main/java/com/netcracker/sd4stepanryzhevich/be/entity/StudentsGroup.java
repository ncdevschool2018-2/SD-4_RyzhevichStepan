package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.*;
import java.util.Objects;


@Entity
@Table(name = "studentsgroup")
public class StudentsGroup {
    private long id_group;
    private String name;
    private Faculty faculty;
    private int course;

    @Id
    @Column(name = "id_group")
      public long getId_group() {
        return id_group;
    }

    public void setId_group(long idGroup) {
        this.id_group = idGroup;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @ManyToOne
    @JoinColumn(name = "id_faculty")
    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }


    @Basic
    @Column(name = "course")
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentsGroup that = (StudentsGroup) o;
        return id_group == that.id_group &&
                faculty == that.faculty &&
                course == that.course &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_group, name, faculty, course);
    }
}
