package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.DiscountPolicy
import com.example.kotlinproductorderservice.product.Product
import io.kotest.matchers.comparables.shouldBeEqualComparingTo
import org.junit.jupiter.api.Test

class OrderTest {

    @Test
    fun getTotalPrice() {
        val order = Order(Product("상품명", 1000, DiscountPolicy.NONE), 2)

        val totalPrice = order.getTotalPrice()

        totalPrice shouldBeEqualComparingTo 2000
    }
}
