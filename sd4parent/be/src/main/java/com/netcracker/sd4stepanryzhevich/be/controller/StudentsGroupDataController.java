package com.netcracker.sd4stepanryzhevich.be.controller;

import com.netcracker.sd4stepanryzhevich.be.entity.StudentsGroup;
import com.netcracker.sd4stepanryzhevich.be.service.StudentsGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/group")
public class StudentsGroupDataController {
    private StudentsGroupService studentsGroupService;

    @Autowired
    public StudentsGroupDataController(StudentsGroupService studentsGroupService) {
        this.studentsGroupService = studentsGroupService;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity<StudentsGroup> getStudentsGroupById(@PathVariable(name = "id") Long id) {
        Optional<StudentsGroup> group = studentsGroupService.getStudentsGroupById(id);
        if(group.isPresent()){
            return ResponseEntity.ok(group.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<StudentsGroup> getAllStudentsGroups() {
        return studentsGroupService.getAllStudentsGroups();
    }

    @RequestMapping(method = RequestMethod.POST)
    public StudentsGroup saveStudentsGroup(@RequestBody StudentsGroup studentsGroup) {
        return studentsGroupService.saveStudentsGroup(studentsGroup);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteStudentsGroup(@PathVariable(name = "id") Long id) {
        studentsGroupService.deleteStudentsGroup(id);
        return ResponseEntity.noContent().build();
    }
}
