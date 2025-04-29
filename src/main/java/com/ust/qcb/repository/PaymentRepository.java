package com.ust.qcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.qcb.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	Payment findByBookingId(Long bookingId);
}