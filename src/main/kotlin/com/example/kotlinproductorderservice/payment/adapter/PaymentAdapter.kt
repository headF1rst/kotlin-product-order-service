package com.example.kotlinproductorderservice.payment.adapter

import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.order.adapter.OrderRepository
import com.example.kotlinproductorderservice.payment.domain.Payment
import com.example.kotlinproductorderservice.payment.application.port.PaymentPort
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import java.lang.IllegalArgumentException

@Component
class PaymentAdapter(
    val paymentGateway: PaymentGateway,
    val paymentRepository: PaymentRepository,
    val orderRepository: OrderRepository,
) : PaymentPort {
    override fun getOrder(orderId: Long): Order {
        return orderRepository.findByIdOrNull(orderId)?: throw IllegalArgumentException("주문이 존재하지 않습니다.")
    }

    override fun pay(totalPrice: Int, cardNumber: String) {
        paymentGateway.execute(totalPrice, cardNumber)
    }

    override fun save(payment: Payment) {
        paymentRepository.save(payment)
    }

}
