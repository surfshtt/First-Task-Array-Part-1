package test.ch2.sort.bubble;

import ch1.array.impl.ArrayStringEntity;
import ch1.builder.impl.StringArrayBuilder;
import ch2.sort.impl.string.SortBubbleString;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BubbleSortStringTest {

    private SortBubbleString sortBubbleString;

    @BeforeEach
    void setUp(){
        sortBubbleString = new SortBubbleString();
    }

    @Test
    void testSortWithStrings() {
        ArrayStringEntity arrayEntity = StringArrayBuilder.create("hello", "hell", "hel", "he", "h").build();
        List<String> expected = Arrays.asList("h", "he", "hel", "hell", "hello");

        sortBubbleString.sort(arrayEntity);
        List<String> actual = arrayEntity.getElements();

        Assertions.assertEquals(expected, actual);
    }
}
