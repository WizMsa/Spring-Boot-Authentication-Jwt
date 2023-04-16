package com.mnesa.security.auth;

import lombok.Data;

@Data
public class RegisterRequest {
    private String firstname;
    private String lastname;
    private String password;
    private String email;
}
