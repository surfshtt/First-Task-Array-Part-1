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
        String filePath = "prog/src/ch2/data/dataIntegerCorrect.txt";
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        ArrayIntegerEntity actual = arrayFactory.createIntegerArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateIntegerArrayFromFileWithDashes() throws ArrayCreationException {
        String filePath = "prog/src/ch2/data/dataIntegerCorrect2.txt";
        List<Integer> expected = Arrays.asList(10, 20, 30, 40, 50);

        ArrayIntegerEntity actual = arrayFactory.createIntegerArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateIntegerArrayFromFileWithIncorrectData() {
        String filePath = "prog/src/ch2/data/dataIntegerIncorrect.txt";

 & Then
        Assertions.assertThrows(ArrayCreationException.class, () -> {
            arrayFactory.createIntegerArrayFromFile(filePath);
        });
    }

    @Test
    void testCreateStringArrayFromFile() throws ArrayCreationException {
        String filePath = "prog/src/ch2/data/dataStringCorrect.txt";
        List<String> expected = Arrays.asList("hello", "world", "java", "programming");

        ArrayStringEntity actual = arrayFactory.createStringArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateStringArrayFromFileWithDashes() throws ArrayCreationException {
        String filePath = "prog/src/ch2/data/dataStringCorrect2.txt";
        List<String> expected = Arrays.asList("test", "example", "sample", "data");

        ArrayStringEntity actual = arrayFactory.createStringArrayFromFile(filePath);

        Assertions.assertEquals(expected, actual.getElements());
    }

    @Test
    void testCreateIntegerArrayFromNonExistentFile() {
        String filePath = "prog/src/ch2/data/nonExistentFile.txt";

 & Then
        Assertions.assertThrows(ArrayCreationException.class, () -> {
            arrayFactory.createIntegerArrayFromFile(filePath);
        });
    }
}
