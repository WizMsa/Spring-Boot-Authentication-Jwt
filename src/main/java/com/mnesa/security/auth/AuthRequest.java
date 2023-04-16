package com.mnesa.security.auth;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class AuthRequest {
    private String email;
    private String password;
}
