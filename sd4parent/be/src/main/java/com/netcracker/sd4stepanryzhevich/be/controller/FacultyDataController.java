package com.netcracker.sd4stepanryzhevich.be.controller;

import com.netcracker.sd4stepanryzhevich.be.entity.Faculty;
import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;
import com.netcracker.sd4stepanryzhevich.be.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/faculty")
public class FacultyDataController {
    private FacultyService facultyService;

    @Autowired
    public FacultyDataController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<Faculty> getFacultyById(@PathVariable(name = "id") Long id) {
        Optional<Faculty> faculty = facultyService.getFacultyById(id);
        if(faculty.isPresent()){
            return ResponseEntity.ok(faculty.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Faculty> getAllFaculties() {
        return facultyService.getAllFaculties();
    }


    @RequestMapping(method = RequestMethod.POST)
    public Faculty saveFaculty(@RequestBody Faculty faculty) {
        return facultyService.saveFaculty(faculty);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteFaculty(@PathVariable(name = "id") Long id) {
        facultyService.deleteFaculty(id);
        return ResponseEntity.noContent().build();
    }
}
