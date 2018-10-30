package com.netcracker.sd4stepanryzhevich.fapi.service.impl;

import com.netcracker.sd4stepanryzhevich.fapi.models.ProfessorViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.ProfessorDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

@Service
public class ProfessorDataServiceImpl implements ProfessorDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<ProfessorViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        ProfessorViewModel[] professorViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/professor-list/", ProfessorViewModel[].class);
        return professorViewModelResponse == null ? Collections.emptyList() : Arrays.asList(professorViewModelResponse);
    }

    @Override
    public ProfessorViewModel getProfessorById(Long id) {
        return null;
    }

    @Override
    public ProfessorViewModel saveProfessor(ProfessorViewModel professor) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/professor-list", professor, ProfessorViewModel.class).getBody();
    }

    @Override
    public void deleteProfessor(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/professor-list/" + id);
    }
}
