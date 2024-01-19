package com.example.kotlinproductorderservice.payment.adapter

import com.example.kotlinproductorderservice.payment.domain.Payment
import org.springframework.data.jpa.repository.JpaRepository

interface PaymentRepository: JpaRepository<Payment, Long>
