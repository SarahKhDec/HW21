package org.example.HW21.service;

import org.example.HW21.entity.Services;

import java.util.List;

public interface ServicesService {

    void save(Services services);
    List<Services> findAll();
    Services findById(Long id);
}
