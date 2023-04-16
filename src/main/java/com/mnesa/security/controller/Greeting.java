package com.mnesa.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class Greeting {
    @GetMapping("/")
    public String login() {
//        return new ResponseEntity<>("Login", HttpStatus.OK);}
        return "/login";
    }
}
