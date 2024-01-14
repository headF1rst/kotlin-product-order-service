package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.Product

class Order(
    private val product: Product,
    private val quantity: Int,
) {

    var id: Long = 0

    init {
        require(quantity > 0) { "수량은 0보다 커야 합니다." }
    }

    fun assignId(id: Long) {
        this.id = id
    }
}