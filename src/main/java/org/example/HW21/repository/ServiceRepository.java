package org.example.HW21.repository;

import org.example.HW21.entity.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Services, Long> {
}
