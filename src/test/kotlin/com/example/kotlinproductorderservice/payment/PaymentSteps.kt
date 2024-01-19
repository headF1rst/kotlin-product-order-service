package com.example.kotlinproductorderservice.payment

import com.example.kotlinproductorderservice.payment.application.service.PaymentRequest
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType

class PaymentSteps {
    companion object {

        fun 주문결제요청_생성(): PaymentRequest {
            val orderId = 1L
            val cardNumber = "1234-1234-1234-1234"
            return PaymentRequest(orderId, cardNumber)
        }

        fun 주문결제요청(request: PaymentRequest): ExtractableResponse<Response>? =
            RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .`when`()
                .post("/payments")
                .then().log().all()
                .extract()
    }
}
