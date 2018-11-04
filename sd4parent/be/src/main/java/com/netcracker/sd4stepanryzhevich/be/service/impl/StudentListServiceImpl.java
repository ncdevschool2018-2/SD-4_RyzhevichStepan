package com.netcracker.sd4stepanryzhevich.be.service.impl;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import com.netcracker.sd4stepanryzhevich.be.repository.StudentListRepository;
import com.netcracker.sd4stepanryzhevich.be.service.StudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentListServiceImpl implements StudentListService {

    private StudentListRepository repository;

    @Autowired
    public StudentListServiceImpl(StudentListRepository repository){
        this.repository = repository;
    }

    @Override
    public Student saveStudentList(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> getStudentListById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Student> getAllStudentLists() {
        return repository.findAll();
    }

    @Override
    public void deleteStudentList(Long id) {
        repository.deleteById(id);
    }

//    @Override
//    public String getGroupName() {
//        return this.repository.getGroupName();
//    }
}
