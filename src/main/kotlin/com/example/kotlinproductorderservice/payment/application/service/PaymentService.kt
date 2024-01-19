package com.example.kotlinproductorderservice.payment.application.service

import com.example.kotlinproductorderservice.payment.application.port.PaymentPort
import com.example.kotlinproductorderservice.payment.domain.Payment
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/payments")
class PaymentService(
    val paymentPort: PaymentPort,
) {

    @PostMapping
    @Transactional
    fun payment(
        @RequestBody request: PaymentRequest
    ): ResponseEntity<Void> {
        val order = paymentPort.getOrder(request.orderId)
        val payment = Payment(order, request.cardNumber)

        paymentPort.pay(payment.getPrice(), payment.cardNumber)
        paymentPort.save(payment)

        return ResponseEntity.ok().build();
    }
}
