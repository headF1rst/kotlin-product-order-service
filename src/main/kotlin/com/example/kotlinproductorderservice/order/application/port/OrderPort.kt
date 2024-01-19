package com.example.kotlinproductorderservice.order.application.port

import com.example.kotlinproductorderservice.order.domain.Order
import com.example.kotlinproductorderservice.product.domain.Product

interface OrderPort {
    fun getProductById(productId: Long): Product

    fun save(order: Order)
}
