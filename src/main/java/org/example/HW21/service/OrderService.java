package org.example.HW21.service;

import org.example.HW21.entity.Customer;
import org.example.HW21.entity.Offers;
import org.example.HW21.entity.Orders;
import org.example.HW21.entity.SubService;
import org.example.HW21.entity.enumeration.OrderStatus;

import java.util.List;
import java.util.Set;

public interface OrderService {

    void create(Orders orders);
    List<Orders> findAllByExpertSubService();
    Orders findByIdAndStatus(Long id, Set<SubService> subServices);
    void updateOrderStatusToSelect(Orders orders, Offers offers);
    Orders findByIdAndCustomerId(Long id, Long customerId);
    void updateOrderStatusToComePlace(Orders orders, Offers offers);
    void updateOrderStatusToStarted(Orders orders);
    void updateOrderStatusToDone(Orders orders);
    List<Orders> findAllDoneOrder();
    void paymentWithOneMethod(Orders orders);
    Boolean paymentWithTwoMethod(Orders orders);
    Orders checkDoneOrder(Orders orders, Customer customer);
    Orders findPaidOrder(Long id, Long customerId);
    List<Orders> findAllOrder(OrderStatus status);
    List<Orders> findAllExpertOrder(OrderStatus status);
}
