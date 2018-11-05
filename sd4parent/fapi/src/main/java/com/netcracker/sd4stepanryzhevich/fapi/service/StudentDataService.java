package com.netcracker.sd4stepanryzhevich.fapi.service;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentViewModel;

import java.util.List;

public interface StudentDataService {
    List<StudentViewModel> getAll();
    StudentViewModel getStudentById(Long id);
    StudentViewModel saveStudent(StudentViewModel studList);
    void deleteStudent(Long id);
}
