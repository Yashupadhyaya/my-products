import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.example.demo.Product;
import com.example.demo.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    private Product product;

    @BeforeEach
    public void setUp() {
        product = new Product();
        product.setId(1L);
        product.setName("Test Product");
        product.setPrice(99.99);
        product.setQuantity(10);
    }

    @Test
    public void testCreateProduct_success() {
        when(productRepository.save(any(Product.class))).thenReturn(product);

        Product createdProduct = productService.createProduct(product);

        assertThat(createdProduct).isNotNull();
        assertThat(createdProduct.getId()).isEqualTo(product.getId());
        assertThat(createdProduct.getName()).isEqualTo(product.getName());
        assertThat(createdProduct.getPrice()).isEqualTo(product.getPrice());
        assertThat(createdProduct.getQuantity()).isEqualTo(product.getQuantity());
    }

    @Test
    public void testCreateProduct_failure() {
        when(productRepository.save(any(Product.class))).thenThrow(new RuntimeException("Error saving product"));

        try {
            productService.createProduct(product);
        } catch (RuntimeException ex) {
            assertThat(ex).isNotNull();
            assertThat(ex.getMessage()).isEqualTo("Error saving product");
        }
    }

    @Test
    public void testCreateProduct_edgeCase_emptyName() {
        product.setName("");

        try {
            productService.createProduct(product);
        } catch (IllegalArgumentException ex) {
            assertThat(ex).isNotNull();
            assertThat(ex.getMessage()).isEqualTo("Product name cannot be empty");
        }
    }

    @Test
    public void testCreateProduct_edgeCase_negativePrice() {
        product.setPrice(-1.0);

        try {
            productService.createProduct(product);
        } catch (IllegalArgumentException ex) {
            assertThat(ex).isNotNull();
            assertThat(ex.getMessage()).isEqualTo("Product price cannot be negative");
        }
    }

    @Test
    public void testCreateProduct_edgeCase_negativeQuantity() {
        product.setQuantity(-1);

        try {
            productService.createProduct(product);
        } catch (IllegalArgumentException ex) {
            assertThat(ex).isNotNull();
            assertThat(ex.getMessage()).isEqualTo("Product quantity cannot be negative");
        }
    }
}
