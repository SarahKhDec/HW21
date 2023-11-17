package org.example.HW21.service.impl;

import org.example.HW21.entity.Services;
import org.example.HW21.exceptions.service.ServiceExistException;
import org.example.HW21.exceptions.service.ServiceNotFoundException;
import org.example.HW21.repository.ServiceRepository;
import org.example.HW21.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@RequiredArgsConstructor
public class ServicesServiceImpl implements ServicesService {

    private final ServiceRepository serviceRepository;

    @Override
    public void save(Services services) {
        try {
            serviceRepository.save(services);
        } catch (DataIntegrityViolationException e) {
            throw new ServiceExistException(String.format("a service already exists with this name: %s.", services.getName()));
        }
    }

    @Override
    public List<Services> findAll() {
        return serviceRepository.findAll();
    }

    @Override
    public Services findById(Long id) {
        return serviceRepository.findById(id).orElseThrow(
                () -> new ServiceNotFoundException(String.format("no service found with this ID: %s.", id)));
    }
}
