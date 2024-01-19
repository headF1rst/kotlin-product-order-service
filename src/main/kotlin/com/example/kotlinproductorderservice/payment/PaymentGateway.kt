package com.example.kotlinproductorderservice.payment

import org.springframework.stereotype.Component

interface PaymentGateway {
    fun execute(totalPrice: Int, cardNumber: String)
}
