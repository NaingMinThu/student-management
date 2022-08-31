package com.me.studentmanagement.controller;

import com.me.studentmanagement.dto.request.AuthRequest;
import com.me.studentmanagement.dto.response.AuthResponse;
import com.me.studentmanagement.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest authRequest) throws Exception{

        AuthResponse authResponse = new AuthResponse();
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUserName(), authRequest.getPassword())
            );
        }
        catch (Exception exception){
            authResponse.setResponseMessage("login failed!");
            return authResponse;
        }

        String token = jwtUtil.generateToken(authRequest.getUserName());
        authResponse.setResponseMessage("Login success!");
        authResponse.setToken(token);
        return authResponse;
    }
}
