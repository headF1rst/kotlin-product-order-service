package com.example.kotlinproductorderservice.product

class Product(
    private val name: String,
    private val price: Int,
    val discountPolicy: DiscountPolicy
) {
    private var id: Long = 0L

    fun assignedId(id: Long) {
        this.id = id
    }

    init {
        require(name.isNotBlank()) { "상품명은 필수 입니다."}
        require(price > 0) { "상품 가격은 0보다 커야 합니다." }
    }

    fun getId(): Long {
        return this.id
    }
}