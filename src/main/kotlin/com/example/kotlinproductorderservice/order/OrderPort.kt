package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.Product

interface OrderPort {
    fun getProductById(productId: Long): Product

    fun save(order: Order)
}