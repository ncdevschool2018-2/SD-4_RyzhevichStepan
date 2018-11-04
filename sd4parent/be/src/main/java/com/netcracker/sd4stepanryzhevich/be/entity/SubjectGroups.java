package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "subject_groups")
public class SubjectGroups {
    long id_subject_groups;
    long id_subject;
    long id_group;

    @Id
    @Column(name = "id_subject_groups")
    public long getId_subject_groups() {
        return id_subject_groups;
    }

    public void setId_subject_groups(long id_subject_groups) {
        this.id_subject_groups = id_subject_groups;
    }

    @Basic
    @Column(name = "id_subject")
    public long getId_subject() {
        return id_subject;
    }

    public void setId_subject(long id_subject) {
        this.id_subject = id_subject;
    }

    @Basic
    @Column(name = "id_group")
    public long getId_group() {
        return id_group;
    }

    public void setId_group(long id_group) {
        this.id_group = id_group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SubjectGroups that = (SubjectGroups) o;
        return id_subject == that.id_subject &&
                id_group == that.id_group;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id_subject, id_group);
    }


}
