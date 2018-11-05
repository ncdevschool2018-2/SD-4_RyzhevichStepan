package com.netcracker.sd4stepanryzhevich.fapi.controller;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.StudentDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stlist")
public class StudentDataController {

    @Autowired
    private StudentDataService studentDataService;

    @RequestMapping
    public ResponseEntity<List<StudentViewModel>> getAllStudent(){
        return ResponseEntity.ok(studentDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentViewModel> saveStudent
            (@RequestBody StudentViewModel studentList) {
        if (studentList != null) {
            return ResponseEntity.ok(studentDataService.saveStudent(studentList));
        }
        return null;
        }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable String id) {
    studentDataService.deleteStudent(Long.valueOf(id));
    }
}

