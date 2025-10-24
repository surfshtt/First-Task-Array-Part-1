package test.ch1.service;

import ch1.array.impl.ArrayStringEntity;
import ch1.services.impl.ServiceString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ServiceStringTest {

    private ServiceString serviceString;

    @BeforeEach
    void setUp(){
        serviceString = new ServiceString();
    }

    @Test
    void testMethodFindMinWithStrings() {
        //Given
        ArrayStringEntity arrayEntity = new ArrayStringEntity(Arrays.asList("hello", "hi", "world", "a"));
        String expected = "a";

        //When
        String actual = serviceString.findMin(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodFindMaxWithStrings() {
        //Given
        ArrayStringEntity arrayEntity = new ArrayStringEntity(Arrays.asList("hello", "hi", "world", "a"));
        String expected = "world";

        //When
        String actual = serviceString.findMax(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodSumOfElements() {
        //Given
        ArrayStringEntity arrayEntity = new ArrayStringEntity(Arrays.asList("hello", "hi", "world"));
        int expected = 13; // 5 + 2 + 5

        //When
        int actual = serviceString.sumOfElements(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodAverageValue() {
        //Given
        ArrayStringEntity arrayEntity = new ArrayStringEntity(Arrays.asList("hello", "hi", "world"));
        int expected = 4; // 13 / 3 = 4 (целочисленное деление)

        //When
        int actual = serviceString.averageValue(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodReplaceElements() {
        //Given
        ArrayStringEntity arrayEntity = new ArrayStringEntity(Arrays.asList("hello", "hi", "world"));
        String expectedFirst = "world";
        String expectedSecond = "hello";

        //When
        serviceString.replaceElements(arrayEntity, 0, 2);

        //Then
        Assertions.assertEquals(expectedFirst, arrayEntity.getElements().get(0));
        Assertions.assertEquals(expectedSecond, arrayEntity.getElements().get(2));
    }

    @Test
    void testMethodReplaceElement() {
        //Given
        ArrayStringEntity arrayEntity = new ArrayStringEntity(Arrays.asList("hello", "hi", "world"));
        String expected = "test";

        //When
        serviceString.replaceElement(arrayEntity, 0, "test");

        //Then
        Assertions.assertEquals(expected, arrayEntity.getElements().get(0));
    }
}
