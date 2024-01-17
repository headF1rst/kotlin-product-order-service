package com.example.kotlinproductorderservice.payment

class ConsolePaymentGateway(

): PaymentGateway {
    override fun execute(totalPrice: Int, cardNumber: String) {
        println("결제 완료")
    }

}
