package com.netcracker.sd4stepanryzhevich.be.service.impl;

import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;
import com.netcracker.sd4stepanryzhevich.be.repository.StudentsGroupRepository;
import com.netcracker.sd4stepanryzhevich.be.service.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentsGroupServiceImpl implements StudentsGroupService {
    private StudentsGroupRepository repository;

    @Autowired
    public StudentsGroupServiceImpl(StudentsGroupRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<StudentsGroup> getStudentsGroupById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<StudentsGroup> getAllStudentsGroups() {
        return repository.findAll();
    }

    @Override
    public StudentsGroup saveStudentsGroup(StudentsGroup studentsGroup) {
        return repository.save(studentsGroup);
    }

    @Override
    public void deleteStudentsGroup(Long id) {
        repository.deleteById(id);
    }
}
