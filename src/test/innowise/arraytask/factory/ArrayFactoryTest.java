package test.innowise.arraytask.factory;


import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.exception.ArrayCreationException;
import by.innowise.arraytask.factory.ArrayFactory;
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
