import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NameServiceTest {

    private NameService nameService;

    @BeforeEach
    public void setUp() {
        nameService = new NameService();
    }

    @Test
    public void testGetName_whenNameIsNull() {
        nameService.setName(null);
        String name = nameService.getName();
        assertEquals(null, name, "Name should be null");
    }

    @Test
    public void testGetName_whenNameIsEmpty() {
        nameService.setName("");
        String name = nameService.getName();
        assertEquals("", name, "Name should be empty");
    }

    @ParameterizedTest
    @CsvSource({"Alice", "John", "Jane"})
    public void testGetName_whenNameIsNotEmpty(String inputName) {
        nameService.setName(inputName);
        String name = nameService.getName();
        assertEquals(inputName, name, "Name should be equal to the input name");
    }

    @Test
    public void testGetName_whenNameIsTooLong() {
        String longName = "ThisNameIsMoreThan50CharactersLongAndShouldThrowAnException";
        assertThrows(IllegalArgumentException.class, () -> {
            nameService.setName(longName);
        }, "Name should throw an exception if it's too long");
    }
}