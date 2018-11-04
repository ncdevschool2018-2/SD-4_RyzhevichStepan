package com.netcracker.sd4stepanryzhevich.be.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Entity

public class Subject {
    private long id_subject;
    private String name;
    private String type;
    private String timeslot;
    private Date date;

    @Id
    @Column(name = "id_subject")
    public long getId_subject() {
        return id_subject;
    }

    public void setId_subject(long idSubject) {
        this.id_subject = idSubject;
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
    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "timeslot")
    public String getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(String timeslot) {
        this.timeslot = timeslot;
    }

    @Basic
    @Column(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (id_subject != subject.id_subject) return false;
        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        if (type != null ? !type.equals(subject.type) : subject.type != null) return false;
        if (timeslot != null ? !timeslot.equals(subject.timeslot) : subject.timeslot != null) return false;
        if (date != null ? !date.equals(subject.date) : subject.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (id_subject ^ (id_subject >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (timeslot != null ? timeslot.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
