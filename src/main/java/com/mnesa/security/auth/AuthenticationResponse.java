package com.mnesa.security.auth;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Builder
public class AuthenticationResponse {
    public String token;
}
