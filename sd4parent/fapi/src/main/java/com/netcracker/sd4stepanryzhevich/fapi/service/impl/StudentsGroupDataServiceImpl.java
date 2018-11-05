package com.netcracker.sd4stepanryzhevich.fapi.service.impl;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentsGroupViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.StudentsGroupDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StudentsGroupDataServiceImpl implements StudentsGroupDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public StudentsGroupViewModel getStudentsGroupById(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        StudentsGroupViewModel[] studentsGroupViewModels = restTemplate.getForObject(backendServerUrl + "/api/group/", StudentsGroupViewModel[].class);
        if(studentsGroupViewModels != null){
            for (StudentsGroupViewModel groupViewModel : studentsGroupViewModels) {
                if(groupViewModel.getId_group() == id){
                    return  groupViewModel;
                }
            }
        }
        return null;
    }

    @Override
    public List<StudentsGroupViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StudentsGroupViewModel[] studentsGroupViewModels = restTemplate.getForObject(backendServerUrl + "/api/group", StudentsGroupViewModel[].class);
        return studentsGroupViewModels == null ? Collections.emptyList() : Arrays.asList(studentsGroupViewModels);
    }

    @Override
    public StudentsGroupViewModel saveStudentsGroup(StudentsGroupViewModel groupViewModel) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/group", groupViewModel, StudentsGroupViewModel.class).getBody();
    }

    @Override
    public void deleteStudentsGroup(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/group/" + id);
    }
}
