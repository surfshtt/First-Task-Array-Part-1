package test.ch1.array;

import ch1.array.impl.ArrayIntegerEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ArrayIntegerEntityTest {

    @Test
    void testMethodGetPositiveNums() {
        //Given
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        //When
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(expected);
        List<Integer> actual = arrayEntity.getElements();

        //Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void testMethodGetNegativeNums() {
        //Given
        List<Integer> expected = Arrays.asList(-1, -2, -3, -4, -5);

        //When
        ArrayIntegerEntity arrayEntity = new ArrayIntegerEntity(expected);
        List<Integer> actual = arrayEntity.getElements();

        //Then
        Assertions.assertEquals(expected, actual);
    }
 }
