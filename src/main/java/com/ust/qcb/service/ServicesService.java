package com.ust.qcb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ust.qcb.entity.ServiceProvider;
import com.ust.qcb.repository.ServiceProviderRepository;
import com.ust.qcb.repository.ServiceRepository;

@Service
public class ServicesService {
	@Autowired
	private ServiceRepository serviceRepository;
	
	@Autowired
    private ServiceProviderRepository serviceProviderRepository;
	
	public com.ust.qcb.entity.Service addServiceToLoggedInProvider(com.ust.qcb.entity.Service service) {
	    Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String email = auth.getName();

	    ServiceProvider provider = serviceProviderRepository.findByEmail(email);

	    service.setServiceProvider(provider);
	    return serviceRepository.save(service);
	}

    public List<com.ust.qcb.entity.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<com.ust.qcb.entity.Service> getServicesByProvider(Long id) {
        ServiceProvider provider = serviceProviderRepository.findById(id).orElse(null);
        if (provider != null) {
            return provider.getServices();
        }
        throw new RuntimeException("Service provider not found");
    }
}