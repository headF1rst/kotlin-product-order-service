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
        val request = 상품등록요청_생성()

        val response = 상품등록요청(request)

        response!!.statusCode() shouldBe HttpStatus.CREATED.value()
    }

    private fun 상품등록요청(request: AddProductRequest): ExtractableResponse<Response>? =
        RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .`when`()
            .post("/products")
            .then()
            .log().all().extract()

    private fun 상품등록요청_생성(): AddProductRequest {
        val name = "상품명"
        val price = 1000
        val discountPolicy = DiscountPolicy.NONE
        return AddProductRequest(name, price, discountPolicy)
    }
}
