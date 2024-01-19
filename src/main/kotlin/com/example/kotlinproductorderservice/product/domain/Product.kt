package com.example.kotlinproductorderservice.product.domain

import jakarta.persistence.*

@Entity
@Table(name = "products")
class Product(
    var name: String,
    var price: Int,
    var discountPolicy: DiscountPolicy
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    init {
        require(name.isNotBlank()) { "상품명은 필수 입니다."}
        require(price > 0) { "상품 가격은 0보다 커야 합니다." }
    }

    fun update(name: String, price: Int, discountPolicy: DiscountPolicy) {
        require(name.isNotBlank()) { "상품명은 필수 입니다." }
        require(price > 0) { "상품 가격은 0보다 커야 합니다." }
        this.name = name
        this.price = price
        this.discountPolicy = discountPolicy
    }

    fun getDiscountPrice(): Int {
        return discountPolicy.applyDiscount(price)
    }
}
