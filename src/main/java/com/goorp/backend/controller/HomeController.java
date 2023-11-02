package com.goorp.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api")
public class HomeController {

    @GetMapping("/test")
    public Map<String, Object> testHandler() {
        log.info("home");

        Map<String, Object> res = new HashMap<>();
        res.put("SUCCESS", true);
        res.put("SUCCESS_TEXT", "Hello SpringBoot/React");
        return res;
    }
}
