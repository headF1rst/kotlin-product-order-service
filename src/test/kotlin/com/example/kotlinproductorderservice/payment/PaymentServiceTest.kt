package com.example.kotlinproductorderservice.payment

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PaymentServiceTest {

    private lateinit var paymentService: PaymentService
    private lateinit var paymentPort: PaymentPort

    @BeforeEach
    fun setUp() {
        val paymentGateway = ConsolePaymentGateway()
        val paymentRepository = PaymentRepository()
        paymentPort = PaymentAdapter(paymentGateway, paymentRepository)
        paymentService = PaymentService(paymentPort)
    }


    @Test
    fun `상품주문`() {
        val request: PaymentRequest = PaymentSteps.주문결제요청_생성()

        paymentService.payment(request)
    }
}
