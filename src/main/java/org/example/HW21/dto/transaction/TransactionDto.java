package org.example.HW21.dto.transaction;

import org.example.HW21.dto.customer.GetCustomerTransactionDto;
import org.example.HW21.dto.expert.GetExpertTransactionDto;
import org.example.HW21.dto.service.GetServicesDto;
import org.example.HW21.dto.subservice.GetSubServiceTransactionDto;
import org.example.HW21.entity.enumeration.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TransactionDto {

    Long id;
    GetCustomerTransactionDto customer;
    GetExpertTransactionDto expert;
    LocalDateTime registerDate;
    GetSubServiceTransactionDto subService;
    GetServicesDto services;
    Long price;
    String paymentType;
    OrderStatus status;
}
