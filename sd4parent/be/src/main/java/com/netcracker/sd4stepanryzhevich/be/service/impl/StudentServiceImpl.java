package com.netcracker.sd4stepanryzhevich.be.service.impl;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import com.netcracker.sd4stepanryzhevich.be.repository.StudentRepository;
import com.netcracker.sd4stepanryzhevich.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {

    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository){
        this.repository = repository;
    }

    @Override
    public Student saveStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Student> getAllStudent() {
        return repository.findAll();
    }

    @Override
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}
