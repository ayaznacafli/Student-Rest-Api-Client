package com.ayaz.client;

import com.ayaz.domain.Student;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

public class StudentClientForExchange {
    static RestTemplate restTemplate = new RestTemplate();
    static String baseURL = "http://localhost:8082/";

    public String deleteStudent(int id){
        String url = baseURL+"student/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        return restTemplate.exchange(url,HttpMethod.DELETE, entity, String.class).getBody();
    }
    public Student getStudentById(int id){
        String url = baseURL+"/student/"+id;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        return restTemplate.exchange(url, HttpMethod.GET, entity, Student.class).getBody();
    }

    public String updateGenderOfStudent(int id,String gender){
        String URL = baseURL + "/updateGender/"+id+"/"+gender;
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        return restTemplate.exchange(URL, HttpMethod.PUT, entity, String.class).getBody();
    }

    public void addStudent(Student student){
        String URL = baseURL + "/student";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        ResponseEntity<Student> responseEntity = restTemplate.exchange(URL,HttpMethod.POST,entity,Student.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        HttpHeaders httpHeaders = responseEntity.getHeaders();
    }

    public List<Student> getStudentsList(){
        String URL = baseURL+"/students";
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        HttpEntity<Student> entity = new HttpEntity<Student>(headers);
        ResponseEntity<List> responseEntity = restTemplate.exchange(URL,HttpMethod.GET,entity,List.class);
        HttpStatus statusCode = responseEntity.getStatusCode();
        HttpHeaders responseHeaders = responseEntity.getHeaders();
        return responseEntity.getBody();
    }




}
