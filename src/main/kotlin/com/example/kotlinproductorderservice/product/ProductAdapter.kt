package com.example.kotlinproductorderservice.product

class ProductAdapter(
    private val productRepository: ProductRepository,
): ProductPort {
    override fun save(product: Product) {
        productRepository.save(product)
    }
}