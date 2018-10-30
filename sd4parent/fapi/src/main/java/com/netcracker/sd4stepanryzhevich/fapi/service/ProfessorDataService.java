package com.netcracker.sd4stepanryzhevich.fapi.service;


import com.netcracker.sd4stepanryzhevich.fapi.models.ProfessorViewModel;

import java.util.List;

public interface ProfessorDataService {
    List<ProfessorViewModel> getAll();
    ProfessorViewModel getProfessorById(Long id);
    ProfessorViewModel saveProfessor(ProfessorViewModel professor);
    void deleteProfessor(Long id);
}
