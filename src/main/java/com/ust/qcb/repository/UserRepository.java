package com.ust.qcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.qcb.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}