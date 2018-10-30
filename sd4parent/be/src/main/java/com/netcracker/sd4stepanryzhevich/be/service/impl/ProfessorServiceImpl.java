package com.netcracker.sd4stepanryzhevich.be.service.impl;

import com.netcracker.sd4stepanryzhevich.be.entity.Professor;
import com.netcracker.sd4stepanryzhevich.be.repository.ProfessorRepository;
import com.netcracker.sd4stepanryzhevich.be.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ProfessorServiceImpl implements ProfessorService {

    private ProfessorRepository repository;

    @Autowired
    public ProfessorServiceImpl(ProfessorRepository repository){
        this.repository = repository;
    }

    @Override
    public Professor saveProfessor(Professor professor) {
        return repository.save(professor);
    }

    @Override
    public Optional<Professor> getProfessorById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Professor> getAllProfessor() {
        return repository.findAll();
    }

    @Override
    public void deleteProfessor(Long id) {
        repository.deleteById(id);
    }
}
