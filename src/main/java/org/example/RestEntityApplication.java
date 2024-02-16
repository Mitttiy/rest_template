package org.example;

import org.example.output.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestEntityApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestEntityApplication.class, args);
        RestTemplate restTemplate = new RestTemplate();
        Response response = new Response(restTemplate);
        response.makeApiRequests();

    }

}
