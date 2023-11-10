package com.example.kotlinproductorderservice.product

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class ProductServiceTest (
) {
    private lateinit var productService: ProductService
    private lateinit var productPort: ProductPort

    @Test
    fun `상품수정`() {
        val productId = 1L
        val modifyRequest = ModifyProductRequest("상품 수정", 2000, DiscountPolicy.NONE)
        val product = Product("상품명", 1000, DiscountPolicy.NONE)
        stubProductPort(product)
        productService = ProductService(productPort)

        productService.modifyProduct(productId, modifyRequest)

        product.name shouldBe "상품 수정"
        product.price shouldBe 2000
    }

    private fun stubProductPort(product: Product) {
        productPort = object : ProductPort {
            override fun save(product: Product) {
            }

            override fun getProduct(productId: Long): Product {
                return product
            }
        }
    }
}