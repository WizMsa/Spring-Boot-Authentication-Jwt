package com.mnesa.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequestMapping("/demo-controller")
public class demoController {
    @GetMapping("/home")
    public ResponseEntity<String> sayHello(){
        return ResponseEntity.ok("Hello From Secured EndPoint");
    }
}
