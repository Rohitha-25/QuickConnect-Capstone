package com.ust.qcb.controller;

import com.ust.qcb.entity.Booking;
import com.ust.qcb.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping("/book/{userId}/{serviceId}")
    public Booking createBooking(@PathVariable Long userId, @PathVariable Long serviceId) {
        return bookingService.createBooking(userId, serviceId);
    }

    @GetMapping("/user/{userId}")
    public List<Booking> getBookingsByUser(@PathVariable Long userId) {
        return bookingService.getBookingsByUser(userId);
    }

    @GetMapping("/provider/{providerId}")
    public List<Booking> getBookingsByProvider(@PathVariable Long providerId) {
        return bookingService.getBookingsByProvider(providerId);
    }

    @GetMapping("/date/{date}")
    public List<Booking> getBookingsByDate(@PathVariable String date) {
        LocalDate bookingDate = LocalDate.parse(date); // Format: yyyy-mm-dd
        return bookingService.getBookingsByDate(bookingDate);
    }
    
    @GetMapping("/get/{id}")
    public Booking getBookingById(@PathVariable Long id) {
        return bookingService.getBookingById(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteBooking(@PathVariable Long id) {
        bookingService.deleteBooking(id);
        return "Booking deleted successfully";
    }
}