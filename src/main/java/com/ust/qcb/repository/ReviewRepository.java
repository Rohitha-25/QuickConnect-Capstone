package com.ust.qcb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.qcb.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByServiceId(Long serviceId);
}