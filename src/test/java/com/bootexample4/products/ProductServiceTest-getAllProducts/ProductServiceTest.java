import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    private Product product1;
    private Product product2;

    @BeforeEach
    public void setUp() {
        product1 = new Product(1L, "Product 1", "Description 1", 10.0);
        product2 = new Product(2L, "Product 2", "Description 2", 20.0);
    }

    @Test
    public void testGetAllProducts_success() {
        when(productRepository.findAll()).thenReturn(Arrays.asList(product1, product2));

        List<Product> products = productService.getAllProducts();

        assertEquals(2, products.size());
        assertEquals(product1, products.get(0));
        assertEquals(product2, products.get(1));
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllProducts_empty() {
        when(productRepository.findAll()).thenReturn(Collections.emptyList());

        List<Product> products = productService.getAllProducts();

        assertEquals(0, products.size());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllProducts_null() {
        when(productRepository.findAll()).thenReturn(null);

        List<Product> products = productService.getAllProducts();

        assertEquals(0, products.size());
        verify(productRepository, times(1)).findAll();
    }
}
