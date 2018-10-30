package com.netcracker.sd4stepanryzhevich.fapi.controller;

import com.netcracker.sd4stepanryzhevich.fapi.models.ProfessorViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.ProfessorDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/prlist")
public class ProfessorDataController {

    @Autowired
    private ProfessorDataService professorDataService;

    @RequestMapping
    public ResponseEntity<List<ProfessorViewModel>> getAllProfessor(){
        return ResponseEntity.ok(professorDataService.getAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ProfessorViewModel> saveProfessor
            (@RequestBody ProfessorViewModel professor) {
        if (professor != null) {
            return ResponseEntity.ok(professorDataService.saveProfessor(professor));
        }
        return null;
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteProfessor(@PathVariable String id) {
        professorDataService.deleteProfessor(Long.valueOf(id));
    }
}

