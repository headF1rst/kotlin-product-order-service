package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.product.ProductService
import com.example.kotlinproductorderservice.product.ProductSteps
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class OrderServiceTest @Autowired constructor(
    private val orderService: OrderService,
    private val productService: ProductService
) {

    @Test
    fun `상품 주문`() {
        productService.addProduct(ProductSteps.상품등록요청_생성())
        val request = 상품주문요청_생성()

        orderService.createOrder(request)
    }

    private fun 상품주문요청_생성(): CreateOrderRequest {
        val productId = 1L
        val quantity = 2
        return CreateOrderRequest(productId, quantity)
    }
}
