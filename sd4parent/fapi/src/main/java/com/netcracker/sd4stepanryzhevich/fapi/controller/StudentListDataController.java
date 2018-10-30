package com.netcracker.sd4stepanryzhevich.fapi.controller;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.StudentListDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stlist")
public class StudentListDataController {

    @Autowired
    private StudentListDataService studentListDataService;

    @RequestMapping
    public ResponseEntity<List<StudentViewModel>> getAllStudentList(){
        return ResponseEntity.ok(studentListDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<StudentViewModel> saveStudentList
            (@RequestBody StudentViewModel studentList) {
        if (studentList != null) {
            return ResponseEntity.ok(studentListDataService.saveStudentList(studentList));
        }
        return null;
        }
        @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
        public void deleteStudentList(@PathVariable String id) {
        studentListDataService.deleteStudentList(Long.valueOf(id));
        }
    }

