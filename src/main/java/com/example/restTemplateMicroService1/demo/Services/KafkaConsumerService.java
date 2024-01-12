package com.example.restTemplateMicroService1.demo.Services;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    @KafkaListener(topics = "pa1Topic", groupId = "1993")
    public void listen(String message) {
        System.out.println("Received message in group - group_id: " + message);
    }
}
