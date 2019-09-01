package com.example.resttemplate.resttemplateapi.Controller;

import com.example.resttemplate.resttemplateapi.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.List;

@RestController
public class EmployeeController {

    private static final String URL = "http://localhost:8080/employee/";
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/template/employee")
    public List<Employee> getAllEmployee() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(URL, HttpMethod.GET, entity, new ParameterizedTypeReference<List<Employee>>(){}).getBody();
    }

    @GetMapping("/template/employee/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(URL + id, HttpMethod.GET, entity, Employee.class).getBody();
    }

    @PostMapping("/template/employee")
    public Employee addEmployee(@RequestBody Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        return restTemplate.exchange(URL, HttpMethod.POST, entity, Employee.class).getBody();
    }

    @PutMapping("/template/employee/{id}")
    public Employee addEmployee(@PathVariable Long id,
                                @RequestBody Employee employee) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(employee, headers);
        return restTemplate.exchange(URL + id, HttpMethod.PUT, entity, Employee.class).getBody();
    }

    @DeleteMapping("/template/employee/{id}")
    public void addEmployee(@PathVariable Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        HttpEntity<Employee> entity = new HttpEntity<>(headers);
        restTemplate.exchange(URL + id, HttpMethod.DELETE, entity, Employee.class).getBody();
    }
}
