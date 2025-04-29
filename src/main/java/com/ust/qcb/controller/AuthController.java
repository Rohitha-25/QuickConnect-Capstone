package com.ust.qcb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.qcb.dto.AuthenticationRequest;
import com.ust.qcb.dto.AuthenticationResponse;
import com.ust.qcb.dto.RegisterRequest;
import com.ust.qcb.service.AuthService;

import com.ust.qcb.enums.Role;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
	
	@Autowired
	private AuthService authService;

    @PostMapping("/register")
    public String register(@RequestBody RegisterRequest request) {
    	if (request.getRole() == Role.USER) {
            return authService.registerUser(request);
        } else if (request.getRole() == Role.PROVIDER) {
            return authService.registerServiceProvider(request);
        } else {
            return "Invalid role! Must be either USER or PROVIDER.";
        }
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody AuthenticationRequest request) {
        return authService.authenticate(request);
    }
}