package test.innowise.arraytask.specification;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.specification.impl.IntervalSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntervalSpecificationTest {

    private ArrayIntegerEntity positiveArray;
    private ArrayIntegerEntity negativeArray;
    private ArrayIntegerEntity mixedArray;

    @BeforeEach
    void setUp() {
        positiveArray = new ArrayIntegerEntity(new int[]{10, 20, 30, 40});
        negativeArray = new ArrayIntegerEntity(new int[]{-10, -20, -30});
        mixedArray = new ArrayIntegerEntity(new int[]{-5, 0, 5, 10});
    }

    @Test
    void testSpecifyAllElementsWithinInterval() {
        IntervalSpecification specification = new IntervalSpecification(5, 45);
        boolean result = specification.specify(positiveArray);
        assertTrue(result);
    }

    @Test
    void testSpecifyElementBelowMinimum() {
        IntervalSpecification specification = new IntervalSpecification(15, 45);
        boolean result = specification.specify(positiveArray);
        assertFalse(result);
    }

    @Test
    void testSpecifyNegativeInterval() {
        IntervalSpecification specification = new IntervalSpecification(-35, -5);
        boolean result = specification.specify(negativeArray);
        assertTrue(result);
    }

    @Test
    void testSpecifyMixedInterval() {
        IntervalSpecification specification = new IntervalSpecification(-10, 15);
        boolean result = specification.specify(mixedArray);
        assertTrue(result);
    }

    @Test
    void testSpecifySingleElementArray() {
        ArrayIntegerEntity singleElement = new ArrayIntegerEntity(new int[]{15});
        IntervalSpecification specification = new IntervalSpecification(10, 20);
        boolean result = specification.specify(singleElement);
        assertTrue(result);
    }

    @Test
    void testSpecifyEmptyArray() {
        ArrayIntegerEntity emptyArray = new ArrayIntegerEntity(new int[0]);
        IntervalSpecification specification = new IntervalSpecification(0, 100);
        boolean result = specification.specify(emptyArray);
        assertTrue(result);
    }

    @Test
    void testSpecifyNullArray() {
        IntervalSpecification specification = new IntervalSpecification(0, 100);
        boolean result = specification.specify(null);
        assertFalse(result);
    }
}
