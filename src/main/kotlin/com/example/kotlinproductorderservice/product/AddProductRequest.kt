package com.example.kotlinproductorderservice.product

data class AddProductRequest(
    val name: String,
    val price: Int,
    val discountPolicy: DiscountPolicy,
) {
    init {
        require(name.isNotBlank()) { "상품명은 필수 입니다."}
        require(price > 0) { "상품 가격은 0보다 커야 합니다." }
    }
}