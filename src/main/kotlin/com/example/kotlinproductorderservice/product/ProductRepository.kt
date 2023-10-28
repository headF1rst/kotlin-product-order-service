package com.example.kotlinproductorderservice.product

class ProductRepository {

    private val persistence = mutableMapOf<Long, Product>()
    private var sequence = 0L

    fun save(product: Product) {
        product.assignedId(++sequence)
        persistence.put(product.getId(), product)
    }
}