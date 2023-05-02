import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class MyComponentTest {

    private MyComponent myComponent;

    @BeforeEach
    void setUp() {
        myComponent = new MyComponent();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Test description", "Another description", "A very long description that should also work"})
    void setDescription_success(String description) {
        myComponent.setDescription(description);
        assertEquals(description, myComponent.getDescription());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"   "})
    void setDescription_failure(String description) {
        assertThrows(IllegalArgumentException.class, () -> myComponent.setDescription(description));
    }

    @ParameterizedTest
    @CsvSource({
        "Test description, Test description",
        "Another description, Another description",
        "A very long description that should also work, A very long description that should also work"
    })
    void getDescription_success(String input, String expected) {
        myComponent.setDescription(input);
        assertEquals(expected, myComponent.getDescription());
    }
}

class MyComponent {

    private String description;

    public void setDescription(String description) {
        if (description == null || description.trim().isEmpty()) {
            throw new IllegalArgumentException("Description cannot be null or empty");
        }
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}