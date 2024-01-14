package com.example.kotlinproductorderservice.order

import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType

class OrderSteps {
    companion object {
        fun 상품주문요청(request: CreateOrderRequest): ExtractableResponse<Response>? {
            return RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .`when`()
                .post("/orders")
                .then()
                .log().all().extract();
        }

        fun 상품주문요청_생성(): CreateOrderRequest {
            val productId = 1L
            val quantity = 2
            return CreateOrderRequest(productId, quantity)
        }
    }
}