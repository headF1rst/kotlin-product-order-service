package com.example.kotlinproductorderservice.product

import io.kotest.matchers.should
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun update() {
        val product: Product = Product("삼품명", 1000, DiscountPolicy.NONE)

        product.update("상품 수정", 2000, DiscountPolicy.NONE)

        product.name shouldBe "상품 수정"
        product.price shouldBe 2000
        product.discountPolicy shouldBe DiscountPolicy.NONE
    }
}