package com.pet.tradesystem.repository;

import com.pet.tradesystem.domain.Order;

import java.util.List;

public interface OrderRepository extends AppRepository<Order, Integer>  {

    List<Order> findByUserId(Integer primaryKey);
}
