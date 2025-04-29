package com.ust.qcb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ust.qcb.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long>{

}