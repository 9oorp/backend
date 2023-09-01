package com.goorp.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class homeController {
    @GetMapping("/")
    public Map<String, Object> testHandler() {
        log.info("home");

        Map<String, Object> res = new HashMap<>();
        res.put("SUCCESS", true);
        res.put("SUCCESS_TEXT", "Hello SpringBoot/React");
        return res;
    }
}
