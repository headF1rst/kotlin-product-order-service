package com.example.kotlinproductorderservice.product

import com.example.kotlinproductorderservice.product.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {

    @Autowired
    private lateinit var productService: ProductService

    @Test
    fun `상품_등록`() {
        val request = 상품등록요청_생성()
        productService.addProduct(request)
    }

    private fun 상품등록요청_생성(): AddProductRequest {
        val name = "상품명"
        val price = 1000
        val discountPolicy = DiscountPolicy.NONE
        return AddProductRequest(name, price, discountPolicy)
    }
}
