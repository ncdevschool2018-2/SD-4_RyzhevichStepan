package com.netcracker.sd4stepanryzhevich.fapi.service.impl;

import com.netcracker.sd4stepanryzhevich.fapi.models.FacultyViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.models.StudentsGroupViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.FacultyDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class FacultyDataServiceImpl implements FacultyDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public FacultyViewModel getFacultyById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        FacultyViewModel[] facultyViewModels = restTemplate.getForObject(backendServerUrl + "/api/faculty/", FacultyViewModel[].class);
        if(facultyViewModels != null){
            for (FacultyViewModel facultyViewModel : facultyViewModels) {
                if(facultyViewModel.getId_faculty() == id){
                    return  facultyViewModel;
                }
            }
        }
        return null;
    }

    @Override
    public List<FacultyViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        FacultyViewModel[] facultyViewModels = restTemplate.getForObject(backendServerUrl + "/api/faculty", FacultyViewModel[].class);
        return facultyViewModels == null ? Collections.emptyList() : Arrays.asList(facultyViewModels);
    }

    @Override
    public FacultyViewModel saveFaculty(FacultyViewModel facultyViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/faculty", facultyViewModel, FacultyViewModel.class).getBody();
    }

    @Override
    public void deleteFaculty(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/faculty/" + id);
    }
}
