package com.netcracker.sd4stepanryzhevich.be.repository;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentListRepository extends CrudRepository<Student, Long> {
//    @Query(value = "SELECT name from `group` JOIN student ON `group`.id_group=student.id_group", nativeQuery = true)
//    String getGroupName();
}
