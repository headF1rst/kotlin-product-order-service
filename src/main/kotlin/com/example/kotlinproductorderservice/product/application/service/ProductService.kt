package com.example.kotlinproductorderservice.product.application.service

import com.example.kotlinproductorderservice.product.application.port.ProductPort
import com.example.kotlinproductorderservice.product.domain.Product
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/products")
class ProductService(
    private val productPort: ProductPort
) {

    @PostMapping
    @Transactional
    fun addProduct(
        @RequestBody request: AddProductRequest
    ): ResponseEntity<Unit> {
        val product = Product(request.name, request.price, request.discountPolicy)
        productPort.save(product)
        return ResponseEntity.status(HttpStatus.CREATED).build()
    }

    @GetMapping("/{productId}")
    fun findProduct(@PathVariable productId: Long): ResponseEntity<FindProductResponse> {
        val result: Product = productPort.getProduct(productId)

        val response = FindProductResponse(
            productId = result.id,
            name = result.name,
            price = result.price,
            discountPolicy = result.discountPolicy
        )
        return ResponseEntity.ok(response)
    }

    @PatchMapping("/{productId}")
    @Transactional
    fun modifyProduct(
        @PathVariable productId: Long,
        @RequestBody request: ModifyProductRequest
    ): ResponseEntity<Unit> {
        val product: Product = productPort.getProduct(productId)

        product.update(request.name, request.price, request.discountPolicy)
        return ResponseEntity.ok().build()
    }
}
