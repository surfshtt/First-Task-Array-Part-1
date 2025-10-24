package test.ch1.service;

import ch1.array.impl.ArrayStringEntity;
import ch1.builder.impl.StringArrayBuilder;
import ch1.service.impl.ServiceString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ServiceStringTest {

    private ServiceString serviceString;

    @BeforeEach
    void setUp(){
        serviceString = new ServiceString();
    }

    @Test
    void testMethodFindMinWithStrings() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "world", "ye", "a").build();
        String expected = "a";

        String actual = serviceString.findMin(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodFindMaxWithStrings() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "world", "ye", "a").build();
        String expected = "world";

        String actual = serviceString.findMax(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodSumOfElements() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "ye", "world").build();
        int expected = 13; // 5 + 2 + 5

        int actual = serviceString.sumOfElements(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodAverageValue() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "aa", "world").build();
        int expected = 4;

        int actual = serviceString.averageValue(arrayEntity);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodReplaceElements() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "hi", "world").build();
        String expectedFirst = "world";
        String expectedSecond = "hello";

        serviceString.replaceElements(arrayEntity, 0, 2);

        Assertions.assertEquals(expectedFirst, arrayEntity.getElements().get(0));
        Assertions.assertEquals(expectedSecond, arrayEntity.getElements().get(2));
    }

    @Test
    void testMethodReplaceElement() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "hi", "world").build();
        String expected = "test";

        serviceString.replaceElement(arrayEntity, 0, "test");

        List<String> actual = arrayEntity.getElements();
        Assertions.assertEquals(expected, actual.get(0));
    }
}
