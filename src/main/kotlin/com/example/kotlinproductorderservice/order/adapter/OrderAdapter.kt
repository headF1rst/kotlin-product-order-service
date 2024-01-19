package com.example.kotlinproductorderservice.order.adapter

import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.order.application.port.OrderPort
import com.example.kotlinproductorderservice.product.adapter.ProductRepository
import com.example.kotlinproductorderservice.product.domain.Product
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class OrderAdapter (
    private val productRepository: ProductRepository,
    private val orderRepository: OrderRepository,
): OrderPort {
    override fun getProductById(productId: Long): Product {
        return productRepository.findByIdOrNull(productId)
            ?: throw IllegalArgumentException("상품이 존재하지 않습니다.")
    }

    override fun save(order: Order) {
        orderRepository.save(order)
    }
}
