package com.netcracker.sd4stepanryzhevich.be.controller;

import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import com.netcracker.sd4stepanryzhevich.be.service.StudentListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/student-list")
public class StudentController {
    private StudentListService studentListService;

    @Autowired
    public StudentController(StudentListService studentListService) {
        this.studentListService = studentListService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Student> getStudentListById(@PathVariable(name = "id") Long id) {
        Optional<Student> studentList = studentListService.getStudentListById(id);
        if (studentList.isPresent()) {
            return ResponseEntity.ok(studentList.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Student> getAllStudentLists() {
        return studentListService.getAllStudentLists();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Student saveStudentList(@RequestBody Student student) {
        return studentListService.saveStudentList(student);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentList(@PathVariable(name = "id") Long id) {
        studentListService.deleteStudentList(id);
        return ResponseEntity.noContent().build();
    }
}
