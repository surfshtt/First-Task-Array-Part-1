package test.com.innowise.arraytask.factory;


import main.com.innowise.arraytask.entity.ArrayIntegerEntity;
import main.com.innowise.arraytask.entity.ArrayStringEntity;
import main.com.innowise.arraytask.exception.ArrayCreationException;
import main.com.innowise.arraytask.factory.ArrayFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArrayFactoryTest {

    private ArrayFactory arrayFactory;

    @BeforeEach
    void setUp() {
        arrayFactory = new ArrayFactory();
    }

    @Test
    void testCreateIntegerArrayFromFile() throws ArrayCreationException {
        String filePath = "dataInteger.txt";
        int[] expected = {1, 2, 3, 4, 5};

        ArrayIntegerEntity actual = arrayFactory.createIntegerArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getArray());
    }

    @Test
    void testCreateStringArrayFromFile() throws ArrayCreationException {
        String filePath = "dataString.txt";
        String[] expected = {"hello", "hi", "hee", "erg", "rege", "dsf"};

        ArrayStringEntity actual = arrayFactory.createStringArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getArray());
    }

    @Test
    void testCreateStringArrayFromFileWithDashes() throws ArrayCreationException {
        String filePath = "dataString2.txt";
        String[] expected = {"hello", "hi", "hee", "erg", "rege", "dsf"};

        ArrayStringEntity actual = arrayFactory.createStringArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getArray());
    }

    @Test
    void testCreateIntegerArrayFromNonExistFile() {
        String filePath = "aaaa.txt";

        Assertions.assertThrows(ArrayCreationException.class, () -> {arrayFactory.createIntegerArrayFromFile(filePath); });
    }
}
