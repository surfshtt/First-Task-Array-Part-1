package test.ch2.sorts.bubble;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.builder.impl.IntegerArrayBuilder;
import ch2.sorts.impl.integer.SortBubbleInteger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class BubbleSortIntegerTest {

    private SortBubbleInteger sortBubbleInteger;

    @BeforeEach
    void setUp(){
        sortBubbleInteger = new SortBubbleInteger();
    }

    @Test
    void testSortWithPositiveNums() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(5, 4, 3, 2, 1).build();
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        sortBubbleInteger.sort(arrayEntity);
        List<Integer> actual = arrayEntity.getElements();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testSortWithNegativeNums() {
        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(-1, -2, -3, -4, -5).build();
        List<Integer> expected = Arrays.asList(-5, -4, -3, -2, -1);

        sortBubbleInteger.sort(arrayEntity);
        List<Integer> actual = arrayEntity.getElements();

        Assertions.assertEquals(expected, actual);
    }
}
