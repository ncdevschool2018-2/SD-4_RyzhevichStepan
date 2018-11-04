package com.netcracker.sd4stepanryzhevich.be.controller;

import com.netcracker.sd4stepanryzhevich.be.entity.Professor;
import com.netcracker.sd4stepanryzhevich.be.entity.Student;
import com.netcracker.sd4stepanryzhevich.be.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/professor-list")
public class ProfessorController {
    private ProfessorService professorService;

    @Autowired
    public ProfessorController(ProfessorService professorService) { this.professorService = professorService; }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Professor> getProfessorById(@PathVariable(name = "id") Long id) {
        new Student().getStudentsGroup().getName();
        Optional<Professor> professorList = professorService.getProfessorById(id);
        if (professorList.isPresent()) {
            return ResponseEntity.ok(professorList.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @RequestMapping(value = "", method = RequestMethod.GET)

    public Iterable<Professor> getAllProfessor() {
        return professorService.getAllProfessor();
    }

    @RequestMapping(method = RequestMethod.POST)

    public Professor saveProfessor(@RequestBody Professor professor) {
        return professorService.saveProfessor(professor);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)

    public ResponseEntity deleteProfessor(@PathVariable(name = "id") Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.noContent().build();
    }
}
