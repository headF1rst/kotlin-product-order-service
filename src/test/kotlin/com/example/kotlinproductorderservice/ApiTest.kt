package com.example.kotlinproductorderservice

import io.restassured.RestAssured
import org.junit.jupiter.api.BeforeEach
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.server.LocalServerPort

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApiTest {

    @Autowired
    lateinit var dataBaseCleanUp: DataBaseCleanUp

    @LocalServerPort
    private val port = 0

    @BeforeEach
    fun setUp() {
        if (RestAssured.port == RestAssured.UNDEFINED_PORT) {
            RestAssured.port = port
            dataBaseCleanUp.afterPropertiesSet()
        }
        dataBaseCleanUp.execute()
    }
}