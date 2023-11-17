package org.example.HW21.controller;

import org.example.HW21.dto.service.GetServicesDto;
import org.example.HW21.dto.service.ServicesDto;
import org.example.HW21.entity.Services;
import org.example.HW21.mappers.ServicesMapper;
import org.example.HW21.service.impl.ServicesServiceImpl;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/services")
public class ServicesController {

    private final ServicesServiceImpl service;
    private final ServicesMapper servicesMapper;

    @PostMapping("/create")
    @PreAuthorize("hasRole('Admin')")
    public ResponseEntity<String> create(@Valid @RequestBody ServicesDto servicesDto) {
        Services services = servicesMapper.dtoToServices(servicesDto);
        service.save(services);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/findAll")
    @PreAuthorize("hasRole('Admin') or hasRole('Customer')")
    public List<GetServicesDto> findAll() {
        return servicesMapper.servicesListToDtoList(service.findAll());
    }

    @GetMapping("/findById/{id}")
    @PreAuthorize("hasRole('Admin') or hasRole('Customer')")
    public GetServicesDto findById(@PathVariable Long id) {
        return servicesMapper.servicesToDto(service.findById(id));
    }
}
