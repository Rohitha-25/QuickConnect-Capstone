package com.ust.qcb.dto;

import com.ust.qcb.enums.Role;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public class RegisterRequest {
	
	private String name;
    private String email;
    private String password;
    private String phone;
    
    @Enumerated(EnumType.STRING)
    private Role role;
    
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    public Role getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = Role.valueOf(role.toUpperCase());
	}
	
	public RegisterRequest(String name, String email, String password, String phone, Role role) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.role = role;
	}
	
	public RegisterRequest() {
    	
    }
}