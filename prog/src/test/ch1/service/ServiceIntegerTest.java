package test.ch1.service;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.builder.impl.IntegerArrayBuilder;
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
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(Arrays.asList(1, 2, 3, 4, 5)).build();
        int expected = 1;

        int actual = serviceInteger.findMin(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodFindMinWithNegativeNums() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(-1, -2, -3, -4, -5).build();
        int expected = -5;

        int actual = serviceInteger.findMin(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodFindMaxWithPositiveNums() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(1, 2, 3, 4, 5).build();
        int expected = 5;

        int actual = serviceInteger.findMax(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodSumOfElements() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(1, 2, 3, 4, 5).build();
        int expected = 15;

        int actual = serviceInteger.sumOfElements(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodAverageValue() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(1, 2, 3, 4, 5).build();
        int expected = 3;

        int actual = serviceInteger.averageValue(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodCountOfPositiveElements() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(-1, 2, -3, 4, 5).build();
        int expected = 3;

        int actual = serviceInteger.countOfPositiveElements(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodCountOfNegativeElements() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(-1, 2, -3, 4, 5).build();
        int expected = 2;

        int actual = serviceInteger.countOfNegativeElements(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodReplaceElements() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(1, 2, 3, 4, 5).build();
        int expectedFirst = 3;
        int expectedSecond = 1;

        serviceInteger.replaceElements(arrayEntity, 0, 2);

        Assertions.assertEquals(expectedFirst, arrayEntity.getElements().get(0));
        Assertions.assertEquals(expectedSecond, arrayEntity.getElements().get(2));
    }

    @Test
    void testMethodReplaceElement() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(1, 2, 3, 4, 5).build();
        int expected = 10;

        serviceInteger.replaceElement(arrayEntity, 0, 10);

        Assertions.assertEquals(expected, arrayEntity.getElements().get(0));
    }
}
