package org.example.HW21.mappers;

import org.example.HW21.dto.customer.ChangeCustomerPasswordDto;
import org.example.HW21.dto.customer.GetCustomerCreditDto;
import org.example.HW21.dto.customer.RegisterCustomerDto;
import org.example.HW21.dto.customer.GetCustomerDto;
import org.example.HW21.entity.Customer;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    GetCustomerDto customerToDto(Customer customer);
    Customer dtoToCustomer(RegisterCustomerDto customerDto);
    List<GetCustomerDto> customerListToDtoList(List<Customer> customerList);
    Customer changePasswordDtoToCustomer(ChangeCustomerPasswordDto changeCustomerPasswordDto);
    GetCustomerCreditDto customerToCreditDto(Customer customer);
}
