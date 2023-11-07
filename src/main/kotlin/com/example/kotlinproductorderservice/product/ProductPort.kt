package com.example.kotlinproductorderservice.product

interface ProductPort {
    fun save(product: Product)
    fun getProduct(productId: Long): Product
}