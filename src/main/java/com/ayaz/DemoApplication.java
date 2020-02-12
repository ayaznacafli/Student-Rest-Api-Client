package com.ayaz;

import com.ayaz.client.StudentClientForEntity;
import com.ayaz.client.StudentClientForExchange;
import com.ayaz.client.StudentClientForObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);

        StudentClientForExchange client = new StudentClientForExchange();
        System.out.println(client.getStudentById(3));
      /*  StudentClientForEntity client1 = new StudentClientForEntity();
        System.out.println(client1.getStudentById(2));*/

    }


}
