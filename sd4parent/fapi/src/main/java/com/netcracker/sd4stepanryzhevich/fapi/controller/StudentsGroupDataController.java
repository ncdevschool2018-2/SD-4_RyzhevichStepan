package com.netcracker.sd4stepanryzhevich.fapi.controller;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentsGroupViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.StudentsGroupDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/gr")
public class StudentsGroupDataController {
    private StudentsGroupDataService groupService;

    @Autowired
    public StudentsGroupDataController(StudentsGroupDataService groupService) {
        this.groupService = groupService;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<StudentsGroupViewModel> getStudentsGroupById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(groupService.getStudentsGroupById(id));
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<StudentsGroupViewModel>> getAllStudentsGroups() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<StudentsGroupViewModel> saveGroup(@RequestBody StudentsGroupViewModel groupViewModel) {
        if (groupViewModel != null) {
            return ResponseEntity.ok(groupService.saveStudentsGroup(groupViewModel));
        }
        return null;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteStudentsGroup(@PathVariable(name = "id")  Long id) {
        groupService.deleteStudentsGroup(id);
    }
}
