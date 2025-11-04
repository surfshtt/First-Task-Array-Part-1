package test.innowise.arraytask.specification;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.specification.impl.ContainSpecification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainSpecificationTest {

    private ArrayStringEntity stringArray;
    private ArrayIntegerEntity intArray;

    @BeforeEach
    void setUp() {
        stringArray = new ArrayStringEntity(new String[]{"Apple", "Banana", "Cherry", "Date"});
        intArray = new ArrayIntegerEntity(new int[]{1, 2, 3, 4, 5});
    }

    @Test
    void testSpecifyStringElementFound() {
        ContainSpecification specification = new ContainSpecification("Banana");
        boolean result = specification.specify(stringArray);
        assertTrue(result);
    }

    @Test
    void testSpecifyStringElementNotFound() {
        ContainSpecification specification = new ContainSpecification("Elderberry");
        boolean result = specification.specify(stringArray);
        assertFalse(result);
    }

    @Test
    void testSpecifyIntegerElementFound() {
        ContainSpecification specification = new ContainSpecification(3);
        boolean result = specification.specify(intArray);
        assertTrue(result);
    }

    @Test
    void testSpecifyIntegerElementNotFound() {
        ContainSpecification specification = new ContainSpecification(10);
        boolean result = specification.specify(intArray);
        assertFalse(result);
    }

    @Test
    void testSpecifyWithEmptyArray() {
        ArrayStringEntity emptyArray = new ArrayStringEntity(new String[0]);
        ContainSpecification specification = new ContainSpecification("Any");
        boolean result = specification.specify(emptyArray);
        assertFalse(result);
    }
}

