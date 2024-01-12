package com.example.restTemplateMicroService1.demo.thymleafControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Controller
public class MessageController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/check-message/{id}")
    public String checkMessage(@PathVariable String id, Model model) {
        try {
            ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8082/messages/" + id, String.class);
            model.addAttribute("response", response.getBody());
        } catch (HttpClientErrorException.NotFound e) {
            model.addAttribute("response", "Message not found");
        }
        return "result"; // Thymeleaf template to display the response
    }
}
