package com.netcracker.sd4stepanryzhevich.be.controller;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import com.netcracker.sd4stepanryzhevich.be.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student-list")
public class StudentController {
    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentListById(@PathVariable(name = "id") Long id) {
      //  new Student().getStudentsGroup().getName();
        Optional<Student> studentList = studentService.getStudentById(id);
        if (studentList.isPresent()) {
            return ResponseEntity.ok(studentList.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Student> getAllStudentLists() {
        return studentService.getAllStudent();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student saveStudentList(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentList(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
