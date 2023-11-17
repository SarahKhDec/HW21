package org.example.HW21.service.impl;

import org.example.HW21.entity.Comments;
import org.example.HW21.entity.Customer;
import org.example.HW21.entity.Orders;
import org.example.HW21.repository.CommentRepository;
import org.example.HW21.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final ExpertServiceImpl expertService;
    private final OrderServiceImpl orderService;

    @Override
    public Comments create(Comments comments) {
        Customer customer = (Customer) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Orders orders = orderService.findPaidOrder(comments.getOrders().getId(), customer.getId());
        comments.setExpert(orders.getOfferSelected().getExpert());
        comments.setCustomer(customer);
        expertService.updateExpertScore(comments.getScore(), orders.getOfferSelected().getExpert());
        return commentRepository.save(comments);
    }
}
