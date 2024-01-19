package com.example.kotlinproductorderservice.product.application.port

import com.example.kotlinproductorderservice.product.domain.Product

interface ProductPort {
    fun save(product: Product)
    fun getProduct(productId: Long): Product
}
