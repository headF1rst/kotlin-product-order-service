package com.example.kotlinproductorderservice.product

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "products")
class Product(
    val name: String,
    val price: Int,
    val discountPolicy: DiscountPolicy
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L
    init {
        require(name.isNotBlank()) { "상품명은 필수 입니다."}
        require(price > 0) { "상품 가격은 0보다 커야 합니다." }
    }
}