package com.mnesa.security.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return  ResponseEntity.ok(authenticationService.register(request));
    }
    @PostMapping("/auth")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthRequest request){
        return  ResponseEntity.ok(authenticationService.authenticate(request));
    }}
