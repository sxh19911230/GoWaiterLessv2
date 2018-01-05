package com.gowaiterless.api.orderList.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gowaiterless.api.orderList.Order;
import com.gowaiterless.api.orderList.OrderId;

@Repository
public interface OrderRepository extends JpaRepository<Order, OrderId> {}

