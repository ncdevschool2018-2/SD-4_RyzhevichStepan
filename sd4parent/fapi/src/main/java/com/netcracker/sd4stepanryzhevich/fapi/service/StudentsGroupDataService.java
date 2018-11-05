package com.netcracker.sd4stepanryzhevich.fapi.service;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentsGroupViewModel;

import java.util.List;

public interface StudentsGroupDataService {
    StudentsGroupViewModel getStudentsGroupById(Long id);
    List<StudentsGroupViewModel> getAll();
    StudentsGroupViewModel saveStudentsGroup(StudentsGroupViewModel groupViewModel);
    void deleteStudentsGroup(Long id);
}
