package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.product.application.service.ProductService
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    lateinit var productService: ProductService

    @Test
    fun `상품수정`() {
        productService.addProduct(ProductSteps.상품등록요청_생성())
        val productId = 1L
        val modifyRequest = ProductSteps.상품수정요청_생성()

        productService.modifyProduct(productId, modifyRequest)

        val product = productService.findProduct(productId)
        val response = product.body!!
        response.name shouldBe "상품 수정"
        response.price shouldBe 2000
    }
}
