package com.example.restTemplateMicroService1.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ConsumerService {
    @Autowired
    private RestTemplate restTemplate;

    public String getMessageFromProducer() {
        return restTemplate.getForObject("http://localhost:8080/message", String.class);
    }
}