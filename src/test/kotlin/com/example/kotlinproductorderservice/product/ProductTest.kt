package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.product.domain.DiscountPolicy
import com.example.kotlinproductorderservice.product.domain.Product
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ProductTest {

    @Test
    fun update() {
        val product: Product = Product("상품명", 1000, DiscountPolicy.NONE)

        product.update("상품 수정", 2000, DiscountPolicy.NONE)

        product.name shouldBe "상품 수정"
        product.price shouldBe 2000
        product.discountPolicy shouldBe DiscountPolicy.NONE
    }

    @Test
    fun none_discounted_product() {
        val product: Product = Product("상품명", 1000, DiscountPolicy.NONE)

        val discountPrice = product.getDiscountPrice()

        discountPrice shouldBeEqualComparingTo 1000
    }

    @Test
    fun fix_discounted_product() {
        val product: Product = Product("상품명", 1000, DiscountPolicy.NONE)

        val discountPrice = product.getDiscountPrice()

        discountPrice shouldBeEqualComparingTo 1000
    }
}
