package com.example.kotlinproductorderservice.product

import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component

@Component
class ProductAdapter(
    private val productRepository: ProductRepository,
): ProductPort {
    override fun save(product: Product) {
        productRepository.save(product)
    }

    override fun getProduct(productId: Long): Product {
        return productRepository.findByIdOrNull(productId)
            ?: throw IllegalArgumentException("상품이 존재하지 않습니다.")
    }
}