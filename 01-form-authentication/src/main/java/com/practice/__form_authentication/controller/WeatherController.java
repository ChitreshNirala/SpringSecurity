package com.practice.__form_authentication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    @GetMapping("/health")
    public String getHealth() {
        return "Healthy";
    }
}
