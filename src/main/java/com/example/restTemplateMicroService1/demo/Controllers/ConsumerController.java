package com.example.restTemplateMicroService1.demo.Controllers;


import com.example.restTemplateMicroService1.demo.Services.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {
    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consume")
    public String consume() {
        return consumerService.getMessageFromProducer();
    }

}