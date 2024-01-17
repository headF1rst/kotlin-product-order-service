package com.example.kotlinproductorderservice.payment

class PaymentSteps {
    companion object {

        fun 주문결제요청_생성(): PaymentRequest {
            val orderId = 1L
            val cardNumber = "1234-1234-1234-1234"
            return PaymentRequest(orderId, cardNumber)
        }
    }
}
