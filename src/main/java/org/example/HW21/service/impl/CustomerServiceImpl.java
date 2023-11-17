package org.example.HW21.service.impl;

import org.example.HW21.dto.customer.GetModifiedCustomerPasswordTimeDto;
import org.example.HW21.entity.Customer;
import org.example.HW21.exceptions.user.PasswordNotMatchException;
import org.example.HW21.exceptions.user.UserNotFoundException;
import org.example.HW21.repository.CustomerRepository;
import org.example.HW21.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException(String.format("no customer found with this ID: %s.", id)));
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public GetModifiedCustomerPasswordTimeDto changePassword(Customer customer) {
        Customer newCustomer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (!customer.getPassword().equals(customer.getRepeatPassword())) {
            throw new PasswordNotMatchException("the entered password does not match with its repetition.");
        }
        newCustomer.setPassword(passwordEncoder.encode(customer.getPassword()));
        customerRepository.save(newCustomer);
        return new GetModifiedCustomerPasswordTimeDto(LocalDateTime.now(), "the password has been successfully updated.");
    }

    @Override
    public void updateCustomerCredit(Long money, Customer customer) {
        Long credit = customer.getCredit();
        credit -= money;
        customer.setCredit(credit);
        customerRepository.save(customer);
    }

    @Override
    public List<Customer> search(Specification<Customer> spec) {
        return customerRepository.findAll(spec);
    }

    @Override
    public Customer showCredit() {
        return (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
