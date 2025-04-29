package com.ust.qcb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.qcb.entity.Service;
import com.ust.qcb.service.ServicesService;

@RestController
@RequestMapping("/api/services")
public class ServiceController {
	@Autowired
    private ServicesService servicesService;

	@PostMapping("/add")
	public Service addService(@RequestBody Service service) {
	    return servicesService.addServiceToLoggedInProvider(service);
	}

    @GetMapping
    public List<Service> getAllServices() {
        return servicesService.getAllServices();
    }

    @GetMapping("/provider/{id}")
    public List<Service> getByProvider(@PathVariable Long id) {
        return servicesService.getServicesByProvider(id);
    }
}