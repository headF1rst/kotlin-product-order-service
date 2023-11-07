package com.example.kotlinproductorderservice.product

import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest(
    @Autowired
    val productService: ProductService
) {

    @Test
    fun `상품조회`() {
        // given
        val request = ProductSteps.상품등록요청_생성()
        productService.addProduct(request)
        val productId = 1L


        // when
        val response: FindProductResponse = productService.findProduct(productId)

        // then
        response shouldNotBe null
    }
}
