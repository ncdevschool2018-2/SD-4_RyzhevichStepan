package com.netcracker.sd4stepanryzhevich.be.service.impl;

import com.netcracker.sd4stepanryzhevich.be.entity.Faculty;
import com.netcracker.sd4stepanryzhevich.be.repository.FacultyRepository;
import com.netcracker.sd4stepanryzhevich.be.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FacultyServiceImpl implements FacultyService {
    private FacultyRepository repository;

    @Autowired
    public FacultyServiceImpl(FacultyRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Faculty> getFacultyById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Faculty> getAllFaculties() {
        return repository.findAll();
    }

    @Override
    public Faculty saveFaculty(Faculty faculty) {
        return repository.save(faculty);
    }

    @Override
    public void deleteFaculty(Long id) {
        repository.deleteById(id);
    }
}
