import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductService productService;

    @Mock
    private ProductRepository productRepository;

    @Test
    public void testDeleteProduct_success() {
        // Given
        Long id = 1L;
        Product product = new Product();
        product.setId(id);

        // When
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        doNothing().when(productRepository).delete(product);

        // Then
        ResponseEntity<Object> response = productService.deleteProduct(id);

        // Verify
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(productRepository, times(1)).findById(id);
        verify(productRepository, times(1)).delete(product);
    }

    @Test
    public void testDeleteProduct_notFound() {
        // Given
        Long id = 1L;

        // When
        when(productRepository.findById(id)).thenReturn(Optional.empty());

        // Then
        ResponseEntity<Object> response = productService.deleteProduct(id);

        // Verify
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(productRepository, times(1)).findById(id);
        verify(productRepository, times(0)).delete(any(Product.class));
    }

    @Test
    public void testDeleteProduct_error() {
        // Given
        Long id = 1L;
        Product product = new Product();
        product.setId(id);

        // When
        when(productRepository.findById(id)).thenReturn(Optional.of(product));
        doThrow(new RuntimeException("Delete failed")).when(productRepository).delete(product);

        // Then
        try {
            productService.deleteProduct(id);
        } catch (RuntimeException e) {
            assertEquals("Delete failed", e.getMessage());
        }

        // Verify
        verify(productRepository, times(1)).findById(id);
        verify(productRepository, times(1)).delete(product);
    }
}
