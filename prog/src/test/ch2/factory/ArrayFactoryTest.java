package test.ch2.factory;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.array.impl.ArrayStringEntity;
import ch2.exceptions.ArrayCreationException;
import ch2.factory.ArrayFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayFactoryTest {

    private ArrayFactory arrayFactory;

    @BeforeEach
    void setUp() {
        arrayFactory = new ArrayFactory();
    }

    @Test
    void testCreateIntegerArrayFromFile() throws ArrayCreationException {
        String filePath = "prog/src/ch2/data/dataInteger.txt";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        ArrayIntegerEntity actual = arrayFactory.createIntegerArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateStringArrayFromFile() throws ArrayCreationException {
        String filePath = "prog/src/ch2/data/dataString.txt";
        List<String> expected = Arrays.asList("hello", "hi", "hee", "erg", "rege", "dsf");

        ArrayStringEntity actual = arrayFactory.createStringArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateStringArrayFromFileWithDashes() throws ArrayCreationException {
        String filePath = "prog/src/ch2/data/dataString2.txt";
        List<String> expected = Arrays.asList("hello", "hi", "hee", "erg", "rege", "dsf");

        ArrayStringEntity actual = arrayFactory.createStringArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateIntegerArrayFromNonExistFile() {
        String filePath = "prog/src/ch2/data/aaaa.txt";

        Assertions.assertThrows(ArrayCreationException.class, () -> {arrayFactory.createIntegerArrayFromFile(filePath); });
    }
}
