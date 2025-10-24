package test.ch1.array;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.builder.impl.IntegerArrayBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class ArrayIntegerEntityTest {

    @Test
    void testMethodGetPositiveNums() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(expected).build();
        List<Integer> actual = arrayEntity.getElements();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodGetNegativeNums() {
        List<Integer> expected = Arrays.asList(-1, -2, -3, -4, -5);

        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create(expected).build();
        List<Integer> actual = arrayEntity.getElements();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testBuilderWithAddElements() {
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        ArrayIntegerEntity arrayEntity = IntegerArrayBuilder.create()
                .addElements(Arrays.asList(1, 2, 3, 4, 5))
                .build();
        List<Integer> actual = arrayEntity.getElements();

        Assertions.assertEquals(expected, actual);
    }
 }
