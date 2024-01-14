package com.example.kotlinproductorderservice.order

import org.springframework.stereotype.Service

@Service
class OrderService(
    private val orderPort: OrderPort,
) {

    fun createOrder(request: CreateOrderRequest) {
        val product = orderPort.getProductById(request.productId)

        val order = Order(product, request.quantity)

        orderPort.save(order)
    }
}