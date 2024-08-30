package com.example.disertatie.resource;

import com.example.disertatie.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/send")
    public ResponseEntity<Map<String, String>> sendEmail(@RequestBody Map<String, String> emailDetails) {
        String to = emailDetails.get("to");
        String subject = emailDetails.get("subject");
        String text = emailDetails.get("text");

        emailService.sendSimpleMessage(to, subject, text);

        // Create a JSON response
        Map<String, String> response = new HashMap<>();
        response.put("message", "Email sent successfully!");

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
