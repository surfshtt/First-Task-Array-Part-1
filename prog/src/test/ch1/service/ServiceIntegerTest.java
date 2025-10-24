package test.ch1.service;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.services.impl.ServiceInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class ServiceIntegerTest {

    private ServiceInteger serviceInteger;

    @BeforeEach
    void setUp(){
        serviceInteger = new ServiceInteger();
    }

    @Test
    void testMethodFindMinWithPositiveNums() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(1, 2, 3, 4, 5));
        int expected = 1;

        //When
        int actual = serviceInteger.findMin(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodFindMinWithNegativeNums() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(-1, -2, -3, -4, -5));
        int expected = -5;

        //When
        int actual = serviceInteger.findMin(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodFindMaxWithPositiveNums() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(1, 2, 3, 4, 5));
        int expected = 5;

        //When
        int actual = serviceInteger.findMax(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodSumOfElements() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(1, 2, 3, 4, 5));
        int expected = 15;

        //When
        int actual = serviceInteger.sumOfElements(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodAverageValue() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(1, 2, 3, 4, 5));
        int expected = 3;

        //When
        int actual = serviceInteger.averageValue(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodCountOfPositiveElements() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(-1, 2, -3, 4, 5));
        int expected = 3;

        //When
        int actual = serviceInteger.countOfPositiveElements(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodCountOfNegativeElements() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(-1, 2, -3, 4, 5));
        int expected = 2;

        //When
        int actual = serviceInteger.countOfNegativeElements(arrayEntity);

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodReplaceElements() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(1, 2, 3, 4, 5));
        int expectedFirst = 3;
        int expectedSecond = 1;

        //When
        serviceInteger.replaceElements(arrayEntity, 0, 2);

        //Then
        Assertions.assertEquals(expectedFirst, arrayEntity.getElements().get(0));
        Assertions.assertEquals(expectedSecond, arrayEntity.getElements().get(2));
    }

    @Test
    void testMethodReplaceElement() {
        //Given
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(Arrays.asList(1, 2, 3, 4, 5));
        int expected = 10;

        //When
        serviceInteger.replaceElement(arrayEntity, 0, 10);

        //Then
        Assertions.assertEquals(expected, arrayEntity.getElements().get(0));
    }
}
