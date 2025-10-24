package test.ch1.array;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.array.impl.ArrayStringEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayStringEntityTest {

    @Test
    void testMethodGet() {
        //Given
        List<String> expected = Arrays.asList("string1", "string2", "string3");

        //When
        ArrayStringEntity arrayEntity = new  ArrayStringEntity(expected);
        List<String> actual = arrayEntity.getElements();

        //Then
        Assertions.assertEquals(expected, actual);
    }
 }
