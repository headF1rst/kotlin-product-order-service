package com.example.kotlinproductorderservice.payment.domain

import com.example.kotlinproductorderservice.order.domain.Order
import jakarta.persistence.*

@Entity
class Payment(
    @OneToOne
    val order: Order,
    val cardNumber: String
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0L

    fun assignId(id: Long) {
        this.id = id
    }

    fun getPrice(): Int {
        return order.getTotalPrice()
    }

    init {
        require(cardNumber.isNotBlank()) {"카드 번호는 필수입니다."}
    }
}
