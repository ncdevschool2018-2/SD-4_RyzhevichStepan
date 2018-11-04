package com.netcracker.sd4stepanryzhevich.be.service;

import com.netcracker.sd4stepanryzhevich.be.entity.Professor;

import java.util.Optional;

public interface ProfessorService {

    Professor saveProfessor(Professor professor);

    Optional<Professor> getProfessorById(Long id);

    Iterable<Professor> getAllProfessor();

    void deleteProfessor(Long id);

}
