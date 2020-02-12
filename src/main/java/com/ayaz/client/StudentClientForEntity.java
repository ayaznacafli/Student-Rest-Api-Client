package com.ayaz.client;

import com.ayaz.domain.Student;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

public class StudentClientForEntity {

    private String baseURL = "http://localhost:8082/";
    RestTemplate restTemplate = new RestTemplate();

    public Student getStudentById(int id){
        String URL = baseURL+"/student/"+id;
        ResponseEntity<Student> response = restTemplate.getForEntity(URL,Student.class);
        HttpStatus statusCode = response.getStatusCode();
        HttpHeaders httpHeaders = response.getHeaders();
        Student student =  response.getBody();
        return student;
    }

    public List<Student> getStudentList(){
        String URL = baseURL+"/students";
        ResponseEntity<List> response = restTemplate.getForEntity(URL,List.class);
        HttpStatus httpStatus = response.getStatusCode();
        HttpHeaders httpHeaders = response.getHeaders();
        List<Student> students = response.getBody();
        return students;
    }

    public void createStudent(Student student){
        String URL = baseURL + "/student";
        ResponseEntity<Student> response = restTemplate.postForEntity(URL,student,Student.class);
        HttpStatus httpStatus = response.getStatusCode();
        HttpHeaders httpHeaders = response.getHeaders();
        URI uri = restTemplate.postForLocation(URL,student,Student.class);
    }
    public void deleteStudent(int id){
        String URL = baseURL + "/student/"+id;
        restTemplate.delete(URL);
    }
    public void updateStudent(int id, String gender){
        String URL = baseURL + "/updateGender/"+id+"/"+gender;
        restTemplate.put(URL, null);
        System.out.println("Student updates");
    }

}
