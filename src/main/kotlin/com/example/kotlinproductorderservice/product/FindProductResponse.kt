package com.example.kotlinproductorderservice.product

data class FindProductResponse(
    val productId: Long,
    val name: String,
    val price: Int,
    val discountPolicy: DiscountPolicy,
) {
    init {
        require(name.isNotBlank()) { "상품명은 필수입니다." }
    }
}