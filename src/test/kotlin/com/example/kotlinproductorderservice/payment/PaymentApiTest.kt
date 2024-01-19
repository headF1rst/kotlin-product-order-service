package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.order.OrderSteps
import com.example.kotlinproductorderservice.payment.application.service.PaymentRequest
import com.example.kotlinproductorderservice.product.ProductSteps
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

class PaymentApiTest: ApiTest() {

    @Test
    fun `상품주문`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        OrderSteps.상품주문요청(OrderSteps.상품주문요청_생성())
        val request: PaymentRequest = PaymentSteps.주문결제요청_생성()

        val response = PaymentSteps.주문결제요청(request)

        response!!.statusCode() shouldBe HttpStatus.OK.value()
    }
}
