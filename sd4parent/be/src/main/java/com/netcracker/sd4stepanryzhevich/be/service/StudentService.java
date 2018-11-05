package com.netcracker.sd4stepanryzhevich.be.service;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;

import java.util.Optional;

public interface StudentService {

    Student saveStudent(Student student);

    Optional<Student> getStudentById(Long id);

    Iterable<Student> getAllStudent();

    void deleteStudent(Long id);

}
