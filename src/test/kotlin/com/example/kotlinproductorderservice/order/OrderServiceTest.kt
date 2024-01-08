package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.DiscountPolicy
import com.example.kotlinproductorderservice.product.Product
import com.example.kotlinproductorderservice.product.ProductRepository
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.data.repository.findByIdOrNull

class OrderServiceTest {

    private lateinit var orderService: OrderService
    private lateinit var orderPort: OrderPort
    private lateinit var orderRepository: OrderRepository

    @BeforeEach
    fun setUp() {
        orderRepository = OrderRepository()
        orderPort = object: OrderPort {
            override fun getProductById(productId: Long): Product {
                return Product("a", 1, DiscountPolicy.NONE)
            }

            override fun save(order: Order) {
            }
        }
        orderService = OrderService(orderPort)
    }

    @Test
    fun `상품 주문`() {
        val productId = 1L
        val quantity = 2
        val request = CreateOrderRequest(productId, quantity)

        orderService.createOrder(request)
    }

    data class CreateOrderRequest(
        val productId: Long,
        val quantity: Int,
        ) {
        init {
            require(quantity > 0) { "수량은 0보다 커야합니다." }
        }
    }

    class OrderService(
        private val orderPort: OrderPort,
    ) {

        fun createOrder(request: CreateOrderRequest) {
            val product = orderPort.getProductById(request.productId)

            val order = Order(product, request.quantity)

            orderPort.save(order)
        }
    }

    interface OrderPort {
        fun getProductById(productId: Long): Product

        fun save(order: Order)
    }

    class OrderAdapter (
        private val productRepository: ProductRepository,
        private val orderRepository: OrderRepository,
    ): OrderPort {
        override fun getProductById(productId: Long): Product {
            return productRepository.findByIdOrNull(productId)
                ?: throw IllegalArgumentException("상품이 존재하지 않습니다.")
        }

        override fun save(order: Order) {
            orderRepository.save(order)
        }
    }

    class OrderRepository {

        private val persistence: MutableMap<Long, Order> = HashMap()
        private var sequence: Long = 0L

        fun save(order: Order) {
            order.assignId(++sequence)
            persistence[order.id] = order
        }
    }

    class Order(
        private val product: Product,
        private val quantity: Int,
    ) {

        var id: Long = 0

        init {
            require(quantity > 0) { "수량은 0보다 커야 합니다." }
        }

        fun assignId(id: Long) {
            this.id = id
        }
    }
}
