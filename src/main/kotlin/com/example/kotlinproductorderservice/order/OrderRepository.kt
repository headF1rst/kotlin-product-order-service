package com.example.kotlinproductorderservice.order

import org.springframework.stereotype.Repository

@Repository
class OrderRepository {

    private val persistence: MutableMap<Long, Order> = HashMap()
    private var sequence: Long = 0L

    fun save(order: Order) {
        order.assignId(++sequence)
        persistence[order.id] = order
    }
}