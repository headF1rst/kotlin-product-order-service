package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.Product
import com.example.kotlinproductorderservice.product.ProductRepository
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