package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order
import com.example.kotlinproductorderservice.product.DiscountPolicy
import com.example.kotlinproductorderservice.product.Product
import org.springframework.stereotype.Component

@Component
class PaymentAdapter(
    val paymentGateway: PaymentGateway,
    val paymentRepository: PaymentRepository,
) : PaymentPort {
    override fun getOrder(orderId: Long): Order {
        return Order(Product(name = "상품1", price = 1000, discountPolicy = DiscountPolicy.NONE), quantity = 2)
    }

    override fun pay(totalPrice: Int, cardNumber: String) {
        paymentGateway.execute(totalPrice, cardNumber)
    }

    override fun save(payment: Payment) {
        paymentRepository.save(payment)
    }

}
