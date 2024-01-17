package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.Order

class Payment(
    val order: Order,
    val cardNumber: String
) {
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
