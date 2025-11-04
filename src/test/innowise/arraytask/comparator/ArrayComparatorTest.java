package test.innowise.arraytask.comparator;

import by.innowise.arraytask.comparator.ArrayComparator;
import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayComparatorTest {

    private ArrayIntegerEntity intArray1;
    private ArrayIntegerEntity intArray2;
    private ArrayIntegerEntity intArray3;
    private ArrayStringEntity stringArray1;
    private ArrayStringEntity stringArray2;

    @BeforeEach
    void setUp() {
        intArray1 = new ArrayIntegerEntity(new int[]{1, 2, 3});
        intArray2 = new ArrayIntegerEntity(new int[]{4, 5});
        intArray3 = new ArrayIntegerEntity(new int[]{-1, -2});

        stringArray1 = new ArrayStringEntity(new String[]{"abc", "def"});
        stringArray2 = new ArrayStringEntity(new String[]{"a"});
    }

    @Test
    void testIdComparatorWithDifferentHashCodes() {
        int result = ArrayComparator.HASH_CODE.compare(intArray1, intArray2);
        assertTrue(result != 0);
    }

    @Test
    void testIdComparatorWithSameArray() {
        int result = ArrayComparator.HASH_CODE.compare(intArray1, intArray1);
        assertEquals(0, result);
    }

    @Test
    void testIdComparatorSorting() {
        List<ArrayIntegerEntity> arrays = new ArrayList<>();
        arrays.add(intArray3);
        arrays.add(intArray1);
        arrays.add(intArray2);

        Collections.sort(arrays, ArrayComparator.HASH_CODE);

        for (int i = 0; i < arrays.size() - 1; i++) {
            assertTrue(arrays.get(i).hashCode() <= arrays.get(i + 1).hashCode());
        }
    }

    @Test
    void testSumComparatorWithDifferentSums() {
        int result = ArrayComparator.SUM.compare(intArray1, intArray2);
        assertTrue(result < 0);
    }

    @Test
    void testSumComparatorStringArrays() {
        int result = ArrayComparator.SUM.compare(stringArray1, stringArray2);
        assertTrue(result > 0);
    }

    @Test
    void testSumComparatorSorting() {
        List<ArrayIntegerEntity> arrays = new ArrayList<>();
        arrays.add(intArray3);
        arrays.add(intArray2);
        arrays.add(intArray1);

        Collections.sort(arrays, ArrayComparator.SUM);

        for (int i = 0; i < arrays.size() - 1; i++) {
            int sum1 = calculateSum(arrays.get(i));
            int sum2 = calculateSum(arrays.get(i + 1));
            assertTrue(sum1 <= sum2);
        }
    }

    @Test
    void testMaxSizeComparatorWithDifferentSizes() {
        int result = ArrayComparator.MAX_SIZE.compare(intArray1, intArray2);
        assertTrue(result > 0);
    }

    @Test
    void testMaxSizeComparatorWithSameSize() {
        ArrayIntegerEntity sameSize1 = new ArrayIntegerEntity(new int[]{1, 2});
        ArrayIntegerEntity sameSize2 = new ArrayIntegerEntity(new int[]{3, 4});

        int result = ArrayComparator.MAX_SIZE.compare(sameSize1, sameSize2);
        assertEquals(0, result);
    }

    @Test
    void testMaxSizeComparatorSorting() {
        List<ArrayIntegerEntity> arrays = new ArrayList<>();
        arrays.add(intArray2);
        arrays.add(intArray1);
        arrays.add(intArray3);

        Collections.sort(arrays, ArrayComparator.MAX_SIZE);

        for (int i = 0; i < arrays.size() - 1; i++) {
            assertTrue(arrays.get(i).getLength() <= arrays.get(i + 1).getLength());
        }
    }

    private int calculateSum(ArrayIntegerEntity entity) {
        int[] arr = entity.getArray();
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }
}
