package com.netcracker.sd4stepanryzhevich.be.repository;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentListRepository extends CrudRepository<Student, Long> {
}
