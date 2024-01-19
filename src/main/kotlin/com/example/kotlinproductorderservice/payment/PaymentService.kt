package com.example.kotlinproductorderservice.payment

import org.springframework.stereotype.Service

@Service
class PaymentService(
    val paymentPort: PaymentPort,
) {
    fun payment(request: PaymentRequest) {
        val order = paymentPort.getOrder(request.orderId)

        val payment = Payment(order, request.cardNumber)

        paymentPort.pay(payment.getPrice(), payment.cardNumber)
        paymentPort.save(payment)
    }
}
