package com.shultzlab.todolistapi.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController()
@RequestMapping("/health")
public class HealthController {

    @GetMapping
    public Map<String, Boolean> GetHealth() {
        Map<String, Boolean> response = new HashMap<String, Boolean>();
        response.put("UP", true);
        return response;
    }
}
