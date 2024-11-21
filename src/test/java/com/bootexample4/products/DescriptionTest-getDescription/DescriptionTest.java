import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DescriptionTest {

    @Test
    public void testGetDescription_success() {
        // Arrange
        MyClass myClass = new MyClass();
        myClass.setDescription("This is a sample description");

        // Act
        String description = myClass.getDescription();

        // Assert
        assertNotNull(description);
        assertEquals("This is a sample description", description);
    }

    @ParameterizedTest
    @NullAndEmptySource
    public void testGetDescription_nullAndEmpty(String input) {
        // Arrange
        MyClass myClass = new MyClass();
        myClass.setDescription(input);

        // Act
        String description = myClass.getDescription();

        // Assert
        assertEquals(input, description);
    }

    @ParameterizedTest
    @CsvSource({
            "A single character, A",
            "A short description, This is short",
            "A very long description, Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nam volutpat, odio vel vehicula ullamcorper, elit nunc sollicitudin sapien, eget lacinia erat mi eu odio. Donec bibendum lectus vel lacus bibendum, eget malesuada lectus volutpat."
    })
    public void testGetDescription_variousLengths(String testName, String input) {
        // Arrange
        MyClass myClass = new MyClass();
        myClass.setDescription(input);

        // Act
        String description = myClass.getDescription();

        // Assert
        assertNotNull(description);
        assertEquals(input, description);
    }

    public static class MyClass {
        private String description;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}