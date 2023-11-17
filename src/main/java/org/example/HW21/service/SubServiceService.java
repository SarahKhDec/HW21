package org.example.HW21.service;

import org.example.HW21.entity.SubService;

import java.util.List;

public interface SubServiceService {

    void create(SubService subService);
    SubService findById(Long id);
    List<SubService> findAllByServiceId(Long id);
    SubService update(SubService subService);
}
