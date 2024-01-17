package com.example.kotlinproductorderservice.payment

data class PaymentRequest(
    val orderId: Long,
    val cardNumber: String,
) {

}
