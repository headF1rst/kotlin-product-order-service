import com.example.kotlinproductorderservice.product.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ProductServiceTest {

    private lateinit var productService: ProductService
    private lateinit var productRepository: ProductRepository
    private lateinit var productPort: ProductPort

    @BeforeEach
    fun setUp() {
        productRepository = ProductRepository()
        productPort = ProductAdapter(productRepository)
        productService = ProductService(productPort)
    }

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
