package com.example.kotlinproductorderservice.payment.application.service

data class PaymentRequest(
    val orderId: Long,
    val cardNumber: String,
) {

}
