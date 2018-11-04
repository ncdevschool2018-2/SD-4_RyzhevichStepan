package com.netcracker.sd4stepanryzhevich.be.service;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;

import java.util.Optional;

public interface StudentListService {

    Student saveStudentList(Student student);

    Optional<Student> getStudentListById(Long id);

    Iterable<Student> getAllStudentLists();

    void deleteStudentList(Long id);

}
