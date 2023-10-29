package com.example.kotlinproductorderservice.product

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class ProductService(
    private val productPort: ProductPort
) {

    @Transactional
    fun addProduct(request: AddProductRequest) {
        val product = Product(request.name, request.price, request.discountPolicy)

        productPort.save(product)
    }
}