package com.application.travel_web_app.controller;

import com.application.travel_web_app.exceptions.InternalServerErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test-error")
    public ResponseEntity<String> testError() {
        throw new InternalServerErrorException("Testing Internal Server Error");
    }
}