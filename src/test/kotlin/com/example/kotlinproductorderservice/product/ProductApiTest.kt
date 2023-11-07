package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.ApiTest
import io.kotest.matchers.shouldBe
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class ProductApiTest: ApiTest() {

    @Test
    fun `상품_등록`() {
        val request = ProductSteps.상품등록요청_생성()

        val response = ProductSteps.상품등록요청(request)

        response.statusCode() shouldBe HttpStatus.CREATED.value()
    }
}
