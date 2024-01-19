package com.example.kotlinproductorderservice.product.adapter

import com.example.kotlinproductorderservice.product.domain.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository: JpaRepository<Product, Long> {
}
