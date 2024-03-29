package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.product.application.service.AddProductRequest
import com.example.kotlinproductorderservice.product.application.service.ModifyProductRequest
import com.example.kotlinproductorderservice.product.domain.DiscountPolicy
import io.restassured.RestAssured
import io.restassured.response.ExtractableResponse
import io.restassured.response.Response
import org.springframework.http.MediaType

class ProductSteps {

    companion object {
        fun 상품등록요청(request: AddProductRequest): ExtractableResponse<Response> =
            RestAssured.given().log().all()
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .body(request)
                .`when`()
                .post("/products")
                .then()
                .log().all().extract()

        fun 상품등록요청_생성(): AddProductRequest {
            val name = "상품명"
            val price = 1000
            val discountPolicy = DiscountPolicy.NONE
            return AddProductRequest(name, price, discountPolicy)
        }

        fun 상품조회요청(productId: Long): ExtractableResponse<Response> =
            RestAssured.given().log().all()
                .`when`()
                .get("/products/{productId}", productId)
                .then().log().all().extract()

        fun 상품수정요청_생성(): ModifyProductRequest {
            return ModifyProductRequest("상품 수정", 2000, DiscountPolicy.NONE)
        }

        fun 상품수정요청(productId: Long): ExtractableResponse<Response> =
            RestAssured.given().log().all()
                    .contentType(MediaType.APPLICATION_JSON_VALUE)
                    .body(ProductSteps.상품수정요청_생성())
                    .`when`()
                    .patch("/products/{productId}", productId)
                    .then()
                    .log().all().extract()
    }
}
