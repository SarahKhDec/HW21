package org.example.HW21.mappers;

import org.example.HW21.dto.order.*;
import org.example.HW21.dto.payment.CreatePaymentDto;
import org.example.HW21.entity.Orders;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    Orders orderDtoToOrder(CreateOrderDto createOrderDto);
    List<GetOrderForExpertDto> orderListToDtoList(List<Orders> ordersList);
    GetOrderWithOfferDto orderToOfferDto(Orders orders);
    List<GetOrderWithOfferDto> orderListToOrderListDto(List<Orders> ordersList);
    Orders orderCustomerEmailDtoToOrder(GetOrderByCustomerEmailDto getOrderByCustomerEmailDto);
    Orders paymentDtoToOrder(CreatePaymentDto createPaymentDto);
}
