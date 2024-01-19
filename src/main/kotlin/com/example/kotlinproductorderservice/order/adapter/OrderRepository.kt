package com.example.kotlinproductorderservice.order.adapter

import com.example.kotlinproductorderservice.order.domain.Order
import org.springframework.data.jpa.repository.JpaRepository

interface OrderRepository: JpaRepository<Order, Long>
