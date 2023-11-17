package org.example.HW21.service;

import org.example.HW21.dto.customer.GetModifiedCustomerPasswordTimeDto;
import org.example.HW21.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface CustomerService {

    Customer findById(Long id);
    List<Customer> findAll();
    GetModifiedCustomerPasswordTimeDto changePassword(Customer customer);
    void updateCustomerCredit(Long money, Customer customer);
    List<Customer> search(Specification<Customer> spec);
    Customer showCredit();
}
