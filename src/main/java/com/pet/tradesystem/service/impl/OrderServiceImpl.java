package com.pet.tradesystem.service.impl;

import com.pet.tradesystem.domain.Order;
import com.pet.tradesystem.repository.OrderRepository;
import com.pet.tradesystem.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements AppService<Order, Integer> {

    private OrderRepository orderRepository;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public boolean add(Order entity) {
        return orderRepository.add(entity);
    }

    public List<Order> findByUserId(Integer primaryKey) {
        return orderRepository.findByUserId(primaryKey);
    }

    public Order findById(Integer primaryKey) {
        return orderRepository.findById(primaryKey);
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void update(Order entity) {
        orderRepository.update(entity);
    }

    public void delete(Integer primaryKey) {
        orderRepository.delete(primaryKey);
    }
}
