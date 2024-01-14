package com.example.kotlinproductorderservice.order

import com.example.kotlinproductorderservice.ApiTest
import com.example.kotlinproductorderservice.product.ProductService
import com.example.kotlinproductorderservice.product.ProductSteps
import io.restassured.RestAssured
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType

class OrderApiTest: ApiTest() {

    @Test
    fun `상품 주문`() {
        ProductSteps.상품등록요청(ProductSteps.상품등록요청_생성())
        val request = 상품주문요청_생성()

        val response = RestAssured.given().log().all()
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body(request)
            .`when`()
            .post("/orders")
            .then()
            .log().all().extract();

        assertThat(response.statusCode()).isEqualTo(HttpStatus.CREATED.value())
    }

    private fun 상품주문요청_생성(): CreateOrderRequest {
        val productId = 1L
        val quantity = 2
        return CreateOrderRequest(productId, quantity)
    }
}
