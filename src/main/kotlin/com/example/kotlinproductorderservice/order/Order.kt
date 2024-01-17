package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.Product
import jakarta.persistence.*
import lombok.AccessLevel
import lombok.Getter
import lombok.NoArgsConstructor

@Entity
@Table(name = "orders")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
class Order(
    @OneToOne
    private val product: Product,
    private val quantity: Int,
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long = 0

    init {
        require(quantity > 0) { "수량은 0보다 커야 합니다." }
    }

    fun assignId(id: Long) {
        this.id = id
    }

    fun getTotalPrice(): Int {
        return product.getDiscountPrice() * quantity
    }
}
