package com.example.kotlinproductorderservice.order.application.service

import com.example.kotlinproductorderservice.order.application.port.OrderPort
import com.example.kotlinproductorderservice.order.domain.Order
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrderService(
    private val orderPort: OrderPort,
) {

    @PostMapping
    @Transactional
    fun createOrder(
            @RequestBody request: CreateOrderRequest
    ): ResponseEntity<Void> {
        val product = orderPort.getProductById(request.productId)

        val order = Order(product, request.quantity)

        orderPort.save(order)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }
}
