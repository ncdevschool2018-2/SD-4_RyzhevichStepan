package com.netcracker.sd4stepanryzhevich.be.repository;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
}
