
```java
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PriceServiceTest {

    private static class PriceService {
        private double price;

        public PriceService(double price) {
            this.price = price;
        }

        public double getPrice() {
            return price;
        }
    }

    @Test
    public void testGetPrice_success() {
        PriceService priceService = new PriceService(100.0);
        double expectedPrice = 100.0;

        assertEquals(expectedPrice, priceService.getPrice(), "The price should be 100.0");
    }

    @Test
    public void testGetPrice_negativePrice() {
        assertThrows(IllegalArgumentException.class, () -> new PriceService(-50.0),
                "Price cannot be negative");
    }

    @Test
    public void testGetPrice_zeroPrice() {
        PriceService priceService = new PriceService(0);
        double expectedPrice = 0;

        assertEquals(expectedPrice, priceService.getPrice(), "The price should be 0");
    }

    @Test
    public void testGetPrice_maxValue() {
        PriceService priceService = new PriceService(Double.MAX_VALUE);
        double expectedPrice = Double.MAX_VALUE;

        assertEquals(expectedPrice, priceService.getPrice(), "The price should be Double.MAX_VALUE");
    }

    @Test
    public void testGetPrice_minPositiveValue() {
        PriceService priceService = new PriceService(Double.MIN_VALUE);
        double expectedPrice = Double.MIN_VALUE;

        assertEquals(expectedPrice, priceService.getPrice(), "The price should be Double.MIN_VALUE");
    }
}
