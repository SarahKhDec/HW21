package org.example.HW21.dto.order;

import org.example.HW21.dto.customer.GetCustomerDto;
import org.example.HW21.dto.subservice.GetSubServiceDto;
import org.example.HW21.entity.enumeration.OrderStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class GetOrderDto {

    Long id;
    Long proposedPrice;
    String description;
    LocalDateTime dateAndTime;
    String address;
    OrderStatus orderStatus;
    GetCustomerDto customer;
    GetSubServiceDto subService;
}
