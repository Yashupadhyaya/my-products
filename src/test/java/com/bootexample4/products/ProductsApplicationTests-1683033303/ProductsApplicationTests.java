import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductsApplicationTests {

    @Autowired
    private ProductsApplication productsApplication;

    @MockBean
    private SpringApplication springApplication;

    @Test
    public void testMainSuccess() {
        String[] args = new String[]{"arg1", "arg2"};
        ProductsApplication.main(args);
        verify(springApplication, times(1)).run(ProductsApplication.class, args);
    }

    @Test
    public void testMainFailure() {
        String[] args = new String[]{"arg1", "arg2"};
        doThrow(new RuntimeException("Test exception")).when(springApplication).run(ProductsApplication.class, args);

        ByteArrayOutputStream errContent = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errContent));
        ProductsApplication.main(args);

        assertThat(errContent.toString()).contains("Test exception");
    }

    @Test
    public void testMainNoArgs() {
        String[] args = new String[0];
        ProductsApplication.main(args);
        verify(springApplication, times(1)).run(ProductsApplication.class, args);
    }

    @Test
    public void testMainNullArgs() {
        String[] args = null;
        ProductsApplication.main(args);
        verify(springApplication, times(1)).run(ProductsApplication.class, new String[0]);
    }
}