package com.netcracker.sd4stepanryzhevich.be.service;


import com.netcracker.sd4stepanryzhevich.be.entity.Faculty;
import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;

import java.util.Optional;

public interface FacultyService {
    Optional<Faculty> getFacultyById(Long id);
    Iterable<Faculty> getAllFaculties();
    Faculty saveFaculty(Faculty faculty);
    void deleteFaculty(Long id);
}
