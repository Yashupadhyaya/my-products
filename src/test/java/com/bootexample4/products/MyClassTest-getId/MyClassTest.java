import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MyClassTest {

    private MyClass myClass;

    @BeforeEach
    public void setUp() {
        myClass = new MyClass();
    }

    @Test
    public void testGetIdWhenIdIsNull() {
        // Given
        myClass.setId(null);

        // When
        Long id = myClass.getId();

        // Then
        assertThat(id).isNull();
    }

    @Test
    public void testGetIdWhenIdIsPositive() {
        // Given
        Long expectedId = 123L;
        myClass.setId(expectedId);

        // When
        Long id = myClass.getId();

        // Then
        assertThat(id).isEqualTo(expectedId);
    }

    @Test
    public void testGetIdWhenIdIsNegative() {
        // Given
        Long expectedId = -123L;
        myClass.setId(expectedId);

        // When
        Long id = myClass.getId();

        // Then
        assertThat(id).isEqualTo(expectedId);
    }

    @Test
    public void testGetIdWhenIdIsZero() {
        // Given
        Long expectedId = 0L;
        myClass.setId(expectedId);

        // When
        Long id = myClass.getId();

        // Then
        assertThat(id).isEqualTo(expectedId);
    }

    @Test
    public void testGetIdWhenIdIsMaxValue() {
        // Given
        Long expectedId = Long.MAX_VALUE;
        myClass.setId(expectedId);

        // When
        Long id = myClass.getId();

        // Then
        assertThat(id).isEqualTo(expectedId);
    }

    @Test
    public void testGetIdWhenIdIsMinValue() {
        // Given
        Long expectedId = Long.MIN_VALUE;
        myClass.setId(expectedId);

        // When
        Long id = myClass.getId();

        // Then
        assertThat(id).isEqualTo(expectedId);
    }
}
