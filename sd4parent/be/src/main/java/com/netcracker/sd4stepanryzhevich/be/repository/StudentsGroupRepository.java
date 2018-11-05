package com.netcracker.sd4stepanryzhevich.be.repository;

import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentsGroupRepository extends CrudRepository<StudentsGroup, Long> {
}
