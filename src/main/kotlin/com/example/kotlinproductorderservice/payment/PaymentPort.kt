package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order

interface PaymentPort {
    fun getOrder(orderId: Long): Order
    fun pay(totalPrice: Int, cardNumber: String)
    fun save(payment: Payment)
}
