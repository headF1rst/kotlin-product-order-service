package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.product.domain.DiscountPolicy
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import io.kotest.matchers.ints.shouldBeExactly
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class DiscountPolicyTest {

    @Test
    fun noneDiscountPolicy() {
        val price = 1000

        val discountedPrice = DiscountPolicy.NONE. applyDiscount(price)

        discountedPrice shouldBeEqualComparingTo  price
    }

    @Test
    fun name() {
        val price = 2000

        val discountedPrice = DiscountPolicy.FIX_1000_AMOUNT.applyDiscount(price)

        discountedPrice shouldBeEqualComparingTo 1000
    }
}
