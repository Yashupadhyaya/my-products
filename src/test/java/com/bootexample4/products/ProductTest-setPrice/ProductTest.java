import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ProductTest {

    @Test
    public void setPrice_success() {
        Product product = new Product();
        double expectedPrice = 100.0;
        product.setPrice(expectedPrice);
        assertEquals(expectedPrice, product.getPrice());
    }

    @Test
    public void setPrice_zero() {
        Product product = new Product();
        double expectedPrice = 0.0;
        product.setPrice(expectedPrice);
        assertEquals(expectedPrice, product.getPrice());
    }

    @ParameterizedTest
    @ValueSource(doubles = {Double.MAX_VALUE, Double.MIN_VALUE})
    public void setPrice_edgeCases(double edgeCasePrice) {
        Product product = new Product();
        product.setPrice(edgeCasePrice);
        assertEquals(edgeCasePrice, product.getPrice());
    }

    @ParameterizedTest
    @CsvSource({
            "200.0, 200.0",
            "1.0, 1.0",
            "0.01, 0.01"
    })
    public void setPrice_variousValidValues(double inputPrice, double expectedPrice) {
        Product product = new Product();
        product.setPrice(inputPrice);
        assertEquals(expectedPrice, product.getPrice());
    }
}