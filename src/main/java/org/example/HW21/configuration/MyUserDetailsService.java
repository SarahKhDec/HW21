package org.example.HW21.configuration;

import org.example.HW21.repository.AdminRepository;
import org.example.HW21.repository.CustomerRepository;
import org.example.HW21.repository.ExpertRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class MyUserDetailsService implements UserDetailsService {

    private final ExpertRepository expertRepository;
    private final CustomerRepository customerRepository;
    private final AdminRepository adminRepository;
    private StringBuffer tableName;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        switch (tableName.toString()) {
            case "customer":
                return customerRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("No customer found with this username."));
            case "expert":
                return expertRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("No expert found with this username."));
            case "admin":
                return adminRepository.findByEmail(username).orElseThrow(
                        () -> new UsernameNotFoundException("No admin found with this username."));
        }
        throw new UsernameNotFoundException("No user found with this username.");
    }

    public void setTableName(StringBuffer tableName) {
        this.tableName = tableName;
    }
}
