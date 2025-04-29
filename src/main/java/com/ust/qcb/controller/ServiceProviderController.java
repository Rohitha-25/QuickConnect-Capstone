package com.ust.qcb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.qcb.entity.ServiceProvider;
import com.ust.qcb.service.ServiceProviderService;

@RestController
@RequestMapping("/api/providers")
public class ServiceProviderController {
	@Autowired
    private ServiceProviderService providerService;

    @GetMapping
    public List<ServiceProvider> getAllProviders() {
        return providerService.getAllProviders();
    }

    @GetMapping("/{id}")
    public ServiceProvider getProviderById(@PathVariable Long id) {
        return providerService.getProviderById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProvider(@PathVariable Long id) {
        return providerService.deleteProvider(id);
    }
}