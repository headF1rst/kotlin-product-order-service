package com.example.kotlinproductorderservice.product.domain

enum class DiscountPolicy {
    NONE {
        override fun applyDiscount(price: Int): Int {
            return price
        }
    },
    FIX_1000_AMOUNT {
        override fun applyDiscount(price: Int): Int {
            return Math.max(price - 1000, 0)
        }
    };

    abstract fun applyDiscount(price: Int): Int
}
