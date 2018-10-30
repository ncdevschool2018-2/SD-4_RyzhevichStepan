package com.netcracker.sd4stepanryzhevich.fapi.service;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentViewModel;

import java.util.List;

public interface StudentListDataService {
    List<StudentViewModel> getAll();
    StudentViewModel getStudentListById(Long id);
    StudentViewModel saveStudentList(StudentViewModel studList);
    void deleteStudentList(Long id);
}
