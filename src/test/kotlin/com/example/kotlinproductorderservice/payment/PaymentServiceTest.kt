package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.order.OrderService
import com.example.kotlinproductorderservice.order.OrderSteps
import com.example.kotlinproductorderservice.product.ProductService
import com.example.kotlinproductorderservice.product.ProductSteps
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class PaymentServiceTest @Autowired constructor(
    private val paymentService: PaymentService,
    private val orderService: OrderService,
    private val productService: ProductService,

) {

    @Test
    fun `상품주문`() {
        productService.addProduct(ProductSteps.상품등록요청_생성())
        orderService.createOrder(OrderSteps.상품주문요청_생성())
        val request: PaymentRequest = PaymentSteps.주문결제요청_생성()

        paymentService.payment(request)
    }
}
