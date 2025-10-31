package test.com.innowise.arraytask.sort;

import main.com.innowise.arraytask.builder.ArrayIntegerBuilder;
import main.com.innowise.arraytask.builder.ArrayStringBuilder;
import main.com.innowise.arraytask.entity.ArrayIntegerEntity;
import main.com.innowise.arraytask.sort.impl.ArrayBubbleSortInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArraySortTest {
    private ArrayIntegerBuilder arrayIntegerBuilder;
    private ArrayStringBuilder arrayStringBuilder;

    private ArrayBubbleSortInteger sort;
    private ArrayIntegerEntity intArray;

    @BeforeEach
    void setUp() {
        arrayIntegerBuilder = new ArrayIntegerBuilder();
        sort = new ArrayBubbleSortInteger();
    }

    @Test
    void bubbleSortWithPositiveNumsTest() {
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] actual = {5, 4, 3, 2, 1};
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void bubbleSortWithNegativeNumsTest() {
        int[] expected = new int[]{-5, -4, -3, -2, -1};

        int[] actual = {-1, -2, -3, -4, -5};
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void bubbleSortWithNullArrayTest() {
        int[] actual = null;

        sort.sort(actual);

        assertNull(actual);
    }


    @Test
    void insertionSortWithPositiveNumsTest() {
        int[] expected = new int[]{1, 2, 3, 4, 5};

        int[] actual = {5, 4, 3, 2, 1};
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void insertionSortWithNegativeNumsTest() {
        int[] expected = new int[]{-5, -4, -3, -2, -1};

        int[] actual = {-1, -2, -3, -4, -5};
        sort.sort(actual);

        assertArrayEquals(expected, actual);
    }

    @Test
    void insertionSortWithNullArrayTest() {
        int[] actual = null;

        sort.sort(actual);

        assertNull(actual);
    }
}
