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

    @Test
    fun `상품_조회`() {
        // given
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val productId = 1L

        // when
        val response = RestAssured.given().log().all()
            .`when`()
            .get("/products/{productId}", productId)
            .then().log().all().extract()

        response.statusCode() shouldBe HttpStatus.OK.value()
        response.jsonPath().getString("name") shouldBe "상품명"
    }
}
