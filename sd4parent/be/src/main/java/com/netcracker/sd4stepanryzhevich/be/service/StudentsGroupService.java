package com.netcracker.sd4stepanryzhevich.be.service;

import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;

import java.util.Optional;

public interface StudentsGroupService {
    Optional<StudentsGroup> getStudentsGroupById(Long id);
    Iterable<StudentsGroup> getAllStudentsGroups();
    StudentsGroup saveStudentsGroup(StudentsGroup studentsGroup);
    void deleteStudentsGroup(Long id);
}
