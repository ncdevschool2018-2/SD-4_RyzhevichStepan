package com.netcracker.sd4stepanryzhevich.fapi.service.impl;

import com.netcracker.sd4stepanryzhevich.fapi.models.StudentViewModel;
import com.netcracker.sd4stepanryzhevich.fapi.service.StudentListDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import java.util.Collections;
import java.util.List;

@Service
public class StudentListDataServiceImpl implements StudentListDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<StudentViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StudentViewModel[] studentViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/student-list/", StudentViewModel[].class);
        return studentViewModelResponse == null ? Collections.emptyList() : Arrays.asList(studentViewModelResponse);
    }

    @Override
    public StudentViewModel getStudentListById(Long id) {
        return null;
    }

    @Override
    public StudentViewModel saveStudentList(StudentViewModel studList) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/student-list", studList, StudentViewModel.class).getBody();
    }

    @Override
    public void deleteStudentList(Long id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/student-list/" + id);
    }
}
