package com.alert.collab.security.controller;

import com.alert.collab.security.dto.AuthenticationDTO;
import com.alert.collab.security.dto.TokenDTO;
import com.alert.collab.util.JwtTokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthenticationController {
    private String TOKEN_HEADER = "Authorization";
    private String BEARER_PREFIX = "Bearer ";
    private AuthenticationManager authenticationManager;
    private JwtTokenUtils jwtTokenUtils;
    private UserDetailsService userDetailsService;

    public AuthenticationController(AuthenticationManager authenticationManager, JwtTokenUtils jwtTokenUtils, UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtils = jwtTokenUtils;
        this.userDetailsService = userDetailsService;
    }

    public ResponseEntity<TokenDTO> generateTokenJwt(@Valid @RequestBody AuthenticationDTO authenticationDTO) {

    }
}
