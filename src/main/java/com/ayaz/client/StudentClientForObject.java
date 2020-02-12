package com.ayaz.client;

import com.ayaz.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

public class StudentClientForObject {

    private Logger logger = LoggerFactory.getLogger(StudentClientForObject.class);
    private String baseURL ="http://localhost:8082/";
    private RestTemplate restTemplate = new RestTemplate();

    public String getStudentById(int id){
        String URL = baseURL+"/student/"+id;
        String student = restTemplate.getForObject(URL,String.class);
        logger.info("Student - "+student);
        return student;
    }

    public void createStudent(Student student){
        String URL = baseURL+"/student";
        String response = restTemplate.postForObject(URL,student,String.class);
        logger.info("Response - "+response);
    }

}
