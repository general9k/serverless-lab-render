package ru.rodionov.lab_4.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hello, Serverless!");
    }

    @PostMapping("/echo")
    public ResponseEntity<Map<String, Object>> echo(@RequestBody(required = false) Object body) {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "received");
        response.put("you_sent", body);
        int length = 0;
        if (body != null) length = body.toString().length();
        response.put("length", length);
        return ResponseEntity.ok(response);
    }
}
