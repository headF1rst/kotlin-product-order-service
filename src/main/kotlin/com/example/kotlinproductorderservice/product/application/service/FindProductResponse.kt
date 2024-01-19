package com.example.kotlinproductorderservice.product.application.service

import com.example.kotlinproductorderservice.product.domain.DiscountPolicy

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
