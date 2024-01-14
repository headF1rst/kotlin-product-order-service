package com.example.kotlinproductorderservice.order

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface OrderRepository: JpaRepository<Order, Long>