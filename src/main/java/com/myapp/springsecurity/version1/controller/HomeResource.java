package com.myapp.springsecurity.version1.controller;

import com.myapp.springsecurity.version1.model.AuthenticateRequest;
import com.myapp.springsecurity.version1.model.AuthenticateResponse;
import com.myapp.springsecurity.version1.service.MyUserDetailService;
import com.myapp.springsecurity.version1.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    MyUserDetailService myUserDetailService;

    @Autowired
    JwtUtil jwtUtil;

    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok().body("{\n" +
                "  \"sub\": \"1234567890\",\n" +
                "  \"name\": \"Nuwan\",\n" +
                "  \"iat\": 1516239022\n" +
                "}");
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticateRequest request) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch(BadCredentialsException ex) {
            throw ex;
        }
        String jwtToken = jwtUtil.generateToken(myUserDetailService.loadUserByUsername(request.getUsername()));
        return ResponseEntity.ok(new AuthenticateResponse(jwtToken));
    }
}
