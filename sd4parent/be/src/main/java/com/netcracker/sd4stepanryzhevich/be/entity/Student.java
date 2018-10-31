package com.netcracker.sd4stepanryzhevich.be.entity;


import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    private long idStudent;
    private String firstname;
    private String secondname;
    private String patronymic;
    private String telnumber;
    private String email;
    private Integer course;
    private Integer subgroup;
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_group")
    public Group getGroup(){
       return group;
    }

    public void setGroup(Group group){
        this.group = group;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student")
    public long getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
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

    @Basic
    @Column(name = "course")
    public Integer getCourse() {
        return course;
    }

    public void setCourse(Integer course) {
        this.course = course;
    }

    @Basic
    @Column(name = "subgroup")
    public Integer getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(Integer subgroup) {
        this.subgroup = subgroup;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (idStudent != student.idStudent) return false;
        if (firstname != null ? !firstname.equals(student.firstname) : student.firstname != null) return false;
        if (secondname != null ? !secondname.equals(student.secondname) : student.secondname != null) return false;
        if (patronymic != null ? !patronymic.equals(student.patronymic) : student.patronymic != null) return false;
        if (telnumber != null ? !telnumber.equals(student.telnumber) : student.telnumber != null) return false;
        if (email != null ? !email.equals(student.email) : student.email != null) return false;
        if (course != null ? !course.equals(student.course) : student.course != null) return false;
        if (subgroup != null ? !subgroup.equals(student.subgroup) : student.subgroup != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) (idStudent ^ (idStudent >>> 32));
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        result = 31 * result + (secondname != null ? secondname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        result = 31 * result + (telnumber != null ? telnumber.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (course != null ? course.hashCode() : 0);
        result = 31 * result + (subgroup != null ? subgroup.hashCode() : 0);
        return result;
    }
}
