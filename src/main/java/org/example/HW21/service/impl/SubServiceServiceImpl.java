package org.example.HW21.service.impl;

import org.example.HW21.entity.Services;
import org.example.HW21.entity.SubService;
import org.example.HW21.exceptions.subservice.SubServiceExistException;
import org.example.HW21.exceptions.subservice.SubServiceNotFoundException;
import org.example.HW21.repository.SubServiceRepository;
import org.example.HW21.service.SubServiceService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubServiceServiceImpl implements SubServiceService {

    private final SubServiceRepository subServiceRepository;
    private final ServicesServiceImpl service;


    @Override
    public void create(SubService subService) {
        Services services = service.findById(subService.getServices().getId());
        subService.setServices(services);
        try {
            subServiceRepository.save(subService);
        } catch (DataIntegrityViolationException e) {
            throw new SubServiceExistException(String.format("a sub service already exists with this name: %s in this service: %s."
                    ,subService.getName(), services.getName()));
        }
    }

    @Override
    public SubService findById(Long id) {
        return subServiceRepository.findById(id).orElseThrow(
                () -> new SubServiceNotFoundException(String.format("no sub service found with this ID: %s.", id)));
    }

    @Override
    public List<SubService> findAllByServiceId(Long id) {
        return subServiceRepository.findAllByServices(id);
    }

    @Override
    public SubService update(SubService subService) {
        return subServiceRepository.save(subService);
    }
}
