package com.example.disertatie.resource;

import com.example.disertatie.model.EmailRequest;
import com.example.disertatie.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.disertatie.model.Destination;
import com.example.disertatie.service.DestinationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        emailService.sendSimpleMessage(emailRequest.getTo(), emailRequest.getSubject(), emailRequest.getText());
        return ResponseEntity.ok("Email sent!");
    }
}


