package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.product.adapter.ProductRepository
import io.kotest.matchers.shouldBe
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class ProductApiTest: ApiTest() {

    @Autowired
    lateinit var productRepository: ProductRepository

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
        val response = ProductSteps.상품조회요청(productId)

        response.statusCode() shouldBe HttpStatus.OK.value()
        response.jsonPath().getString("name") shouldBe "상품명"
    }

    @Test
    fun `상품_수정`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val  productId = 1L

        val response = ProductSteps.상품수정요청(productId)

        response.statusCode() shouldBe HttpStatus.OK.value()
        productRepository.findById(productId).get().name shouldBe "상품 수정"
    }
}
