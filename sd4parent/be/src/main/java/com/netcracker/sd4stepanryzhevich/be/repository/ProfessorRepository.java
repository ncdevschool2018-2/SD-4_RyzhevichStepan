package com.netcracker.sd4stepanryzhevich.be.repository;


import com.netcracker.sd4stepanryzhevich.be.entity.Professor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}
