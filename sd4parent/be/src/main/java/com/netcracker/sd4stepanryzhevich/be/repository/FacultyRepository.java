package com.netcracker.sd4stepanryzhevich.be.repository;

import com.netcracker.sd4stepanryzhevich.be.entity.Faculty;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository  extends CrudRepository<Faculty, Long> {
}
