package com.example.kotlinproductorderservice.payment

import org.springframework.stereotype.Repository

@Repository
class PaymentRepository {

    private val persistence = HashMap<Long, Payment>()
    private var sequence = 0L

    fun save(payment: Payment) {
        payment.assignId(++sequence)
        persistence[payment.id] = payment
    }
}
