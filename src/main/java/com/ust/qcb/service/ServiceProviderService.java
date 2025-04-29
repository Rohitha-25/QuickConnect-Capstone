package com.ust.qcb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.qcb.entity.ServiceProvider;
import com.ust.qcb.repository.ServiceProviderRepository;

@Service
public class ServiceProviderService {
	
	@Autowired
	private ServiceProviderRepository serviceProviderRepository;

    public ServiceProvider register(ServiceProvider provider) {
        return serviceProviderRepository.save(provider);
    }

    public List<ServiceProvider> getAllProviders() {
        return serviceProviderRepository.findAll();
    }

    public ServiceProvider getProviderById(Long id) {
        return serviceProviderRepository.findById(id).orElse(null);
    }
    
    public String deleteProvider(Long id) {
        serviceProviderRepository.deleteById(id);
        return "Service provider deleted successfully!";
    }
}