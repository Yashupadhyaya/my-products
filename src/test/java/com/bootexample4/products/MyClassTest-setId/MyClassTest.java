import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class MyClassTest {

    @Test
    public void setId_success() {
        MyClass myClass = new MyClass();
        Long expectedId = 1L;
        myClass.setId(expectedId);
        assertEquals(expectedId, myClass.getId(), "The ID should be set correctly.");
    }

    @Test
    public void setId_null() {
        MyClass myClass = new MyClass();
        assertThrows(NullPointerException.class, () -> myClass.setId(null), "Setting ID to null should throw NullPointerException.");
    }

    @Test
    public void setId_negative() {
        MyClass myClass = new MyClass();
        Long negativeId = -1L;
        assertThrows(IllegalArgumentException.class, () -> myClass.setId(negativeId), "Setting ID to a negative value should throw IllegalArgumentException.");
    }

    @Test
    public void setId_maxLong() {
        MyClass myClass = new MyClass();
        Long maxId = Long.MAX_VALUE;
        myClass.setId(maxId);
        assertEquals(maxId, myClass.getId(), "The ID should be set to the maximum long value.");
    }

    @Test
    public void setId_minLong() {
        MyClass myClass = new MyClass();
        Long minId = Long.MIN_VALUE;
        assertThrows(IllegalArgumentException.class, () -> myClass.setId(minId), "Setting ID to the minimum long value should throw IllegalArgumentException.");
    }
}