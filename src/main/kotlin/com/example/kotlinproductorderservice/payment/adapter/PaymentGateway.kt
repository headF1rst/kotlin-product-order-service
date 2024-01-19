package com.example.kotlinproductorderservice.payment.adapter

interface PaymentGateway {
    fun execute(totalPrice: Int, cardNumber: String)
}
