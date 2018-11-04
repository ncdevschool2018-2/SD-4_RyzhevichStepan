package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.*;


@Entity
@Table(name = "studentsgroup")
public class StudentsGroup {
    private long id_group;
    private String name;
    private long id_faculty;

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

    @Basic
    @Column(name = "id_faculty")
    public long getId_faculty() {
        return id_group;
    }

    public void setId_faculty(long idFaculty) {
        this.id_faculty = idFaculty;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StudentsGroup studentsGroup = (StudentsGroup) o;

        if (id_group != studentsGroup.id_group) return false;
        if (name != null ? !name.equals(studentsGroup.name) : studentsGroup.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_group ^ (id_group >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
