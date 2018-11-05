package com.netcracker.sd4stepanryzhevich.fapi.service;



import com.netcracker.sd4stepanryzhevich.fapi.models.FacultyViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.models.StudentsGroupViewModel;

import java.util.List;

public interface FacultyDataService {
    FacultyViewModel getFacultyById(Long id);
    List<FacultyViewModel> getAll();
    FacultyViewModel saveFaculty(FacultyViewModel facultyViewModel);
    void deleteFaculty(Long id);
}
