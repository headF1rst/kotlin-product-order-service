package com.example.kotlinproductorderservice.payment.application.port

import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.payment.domain.Payment

interface PaymentPort {
    fun getOrder(orderId: Long): Order
    fun pay(totalPrice: Int, cardNumber: String)
    fun save(payment: Payment)
}
