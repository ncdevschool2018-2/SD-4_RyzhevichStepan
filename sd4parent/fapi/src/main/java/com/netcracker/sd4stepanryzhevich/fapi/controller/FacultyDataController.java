package com.netcracker.sd4stepanryzhevich.fapi.controller;

import com.netcracker.sd4stepanryzhevich.fapi.models.FacultyViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.models.StudentsGroupViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.FacultyDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/fc")
public class FacultyDataController {
    private FacultyDataService facultyDataService;

    @Autowired
    public FacultyDataController(FacultyDataService facultyDataService) {
        this.facultyDataService = facultyDataService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<FacultyViewModel> getFacultyById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(facultyDataService.getFacultyById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<FacultyViewModel>> getAllFaculties() {
        return ResponseEntity.ok(facultyDataService.getAll());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<FacultyViewModel> saveFaculty(@RequestBody FacultyViewModel facultyViewModel) {
        if (facultyViewModel != null) {
            return ResponseEntity.ok(facultyDataService.saveFaculty(facultyViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFaculty(@PathVariable(name = "id")  Long id) {
        facultyDataService.deleteFaculty(id);
    }
}
