package com.ust.qcb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ust.qcb.dto.AuthenticationRequest;
import com.ust.qcb.dto.AuthenticationResponse;
import com.ust.qcb.dto.RegisterRequest;
import com.ust.qcb.entity.ServiceProvider;
import com.ust.qcb.entity.User;
import com.ust.qcb.repository.ServiceProviderRepository;
import com.ust.qcb.repository.UserRepository;
import com.ust.qcb.security.JwtUtil;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
    private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUtil jwtUtil;

	public String registerUser(RegisterRequest request) {
    	User user = new User();
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setPhone(request.getPhone());
        user.setRole(request.getRole());
        userRepository.save(user);
        return "User registered successfully!";
    }
	
	public String registerServiceProvider(RegisterRequest request) {
        ServiceProvider serviceProvider = new ServiceProvider();
        serviceProvider.setName(request.getName());
        serviceProvider.setEmail(request.getEmail());
        serviceProvider.setPassword(passwordEncoder.encode(request.getPassword()));
        serviceProvider.setPhone(request.getPhone());
        serviceProvider.setRole(request.getRole());
        serviceProviderRepository.save(serviceProvider);
        return "Service Provider registered successfully!";
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
    	
    	User user = userRepository.findByEmail(request.getEmail());

        if (user == null) {
            ServiceProvider serviceProvider = serviceProviderRepository.findByEmail(request.getEmail());
            
            if (serviceProvider == null) {
                throw new RuntimeException("Invalid email or password");
            }
            
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );
            
            String token = jwtUtil.generateToken(request.getEmail());
            return new AuthenticationResponse(token, "Service Provider login successful!");
        }
    	
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        
        String token = jwtUtil.generateToken(request.getEmail());
        return new AuthenticationResponse(token, "User login successful!");
    }
}