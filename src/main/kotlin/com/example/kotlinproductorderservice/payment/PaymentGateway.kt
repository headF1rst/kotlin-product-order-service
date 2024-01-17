package com.example.kotlinproductorderservice.payment

interface PaymentGateway {
    fun execute(totalPrice: Int, cardNumber: String)
}
