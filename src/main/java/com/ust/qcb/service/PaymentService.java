package com.ust.qcb.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.qcb.entity.Booking;
import com.ust.qcb.entity.Payment;
import com.ust.qcb.repository.BookingRepository;
import com.ust.qcb.repository.PaymentRepository;

@Service
public class PaymentService {
	@Autowired
    private PaymentRepository paymentRepo;

    @Autowired
    private BookingRepository bookingRepo;

    public Payment makePayment(Long bookingId, Payment payment) {
        Booking booking = bookingRepo.findById(bookingId)
                .orElseThrow(() -> new RuntimeException("Booking not found"));

        payment.setBooking(booking);
        payment.setPaymentDateTime(LocalDateTime.now());
        payment.setStatus("SUCCESS");
        payment.setAmount(booking.getAmount());

        return paymentRepo.save(payment);
    }

    public Payment getPaymentByBooking(Long bookingId) {
        return paymentRepo.findByBookingId(bookingId);
    }

    public List<Payment> getAllPayments() {
        return paymentRepo.findAll();
    }
}