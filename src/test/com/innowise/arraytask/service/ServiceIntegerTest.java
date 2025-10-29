package test.com.innowise.arraytask.service;

import main.com.innowise.arraytask.entity.ArrayIntegerEntity;
import main.com.innowise.arraytask.entity.ArrayStringEntity;
import main.com.innowise.arraytask.builder.ArrayIntegerBuilder;
import main.com.innowise.arraytask.builder.ArrayStringBuilder;
import main.com.innowise.arraytask.service.impl.ServiceInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ServiceIntegerTest {
    private ArrayIntegerBuilder arrayIntegerBuilder;
    private ArrayStringBuilder arrayStringBuilder;

    private ServiceInteger service;
    private ArrayIntegerEntity intArray;
    private ArrayStringEntity stringArray;
    
    @BeforeEach
    void setUp() {
        arrayIntegerBuilder = new ArrayIntegerBuilder();
        arrayStringBuilder = new ArrayStringBuilder();

        service = new ServiceInteger();
        int[] testIntArray = {5, -3, 8, -1, 12, 0, -7, 4};
        String[] testStringArray = {"apple", "banana", "cherry", "date", "elderberry"};
        intArray = arrayIntegerBuilder.create(testIntArray);
        stringArray = arrayStringBuilder.create(testStringArray);
    }
    
    @Test
    void testFindMinValue() {
        assertEquals(-7, service.findMinValue(intArray));
    }
    
    @Test
    void testFindMinValueWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMinValue((ArrayIntegerEntity) null);
        });
    }
    
    @Test
    void testFindMinValueWithEmptyArray() {
        ArrayIntegerEntity emptyArray = arrayIntegerBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMinValue(emptyArray);
        });
    }
    
    @Test
    void testFindMaxValue() {
        assertEquals(12, service.findMaxValue(intArray));
    }
    
    @Test
    void testFindMaxValueWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMaxValue((ArrayIntegerEntity) null);
        });
    }
    
    @Test
    void testFindMaxValueWithEmptyArray() {
        ArrayIntegerEntity emptyArray = arrayIntegerBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMaxValue(emptyArray);
        });
    }
    
    @Test
    void testFindMinValueString() {
        assertEquals("apple", service.findMinValue(stringArray));
    }
    
    @Test
    void testFindMaxValueString() {
        assertEquals("elderberry", service.findMaxValue(stringArray));
    }
    
    @Test
    void testReplaceElements() {
        ArrayIntegerEntity result = service.replaceElements(intArray, -3, 99);
        int[] resultArray = result.getArray();
        
        assertEquals(99, resultArray[1]);
        assertEquals(5, resultArray[0]);
        assertEquals(8, resultArray[2]);
    }
    
    @Test
    void testReplaceElementsWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.replaceElements(null, 5, 10);
        });
    }
    
    @Test
    void testReplaceElementsString() {
        ArrayStringEntity result = service.replaceElements(stringArray, "banana", "grape");
        String[] resultArray = result.getArray();
        
        assertEquals("grape", resultArray[1]);
        assertEquals("apple", resultArray[0]);
        assertEquals("cherry", resultArray[2]);
    }
    
    @Test
    void testCalculateSum() {
        assertEquals(18, service.calculateSum(intArray));
    }
    
    @Test
    void testCalculateSumWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateSum(null);
        });
    }
    
    @Test
    void testCalculateSumWithEmptyArray() {
        ArrayIntegerEntity emptyArray = arrayIntegerBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateSum(emptyArray);
        });
    }
    
    @Test
    void testCalculateAverage() {
        double expected = 18.0 / 8.0;
        assertEquals(expected, service.calculateAverage(intArray), 0.001);
    }
    
    @Test
    void testCalculateAverageWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateAverage(null);
        });
    }
    
    @Test
    void testCalculateAverageWithEmptyArray() {
        ArrayIntegerEntity emptyArray = arrayIntegerBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.calculateAverage(emptyArray);
        });
    }
    
    @Test
    void testCountPositiveElements() {
        assertEquals(4, service.countPositiveElements(intArray));
    }
    
    @Test
    void testCountPositiveElementsWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.countPositiveElements(null);
        });
    }
    
    @Test
    void testCountPositiveElementsWithEmptyArray() {
        ArrayIntegerEntity emptyArray = arrayIntegerBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.countPositiveElements(emptyArray);
        });
    }
    
    @Test
    void testCountNegativeElements() {
        assertEquals(3, service.countNegativeElements(intArray));
    }
    
    @Test
    void testCountNegativeElementsWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.countNegativeElements(null);
        });
    }
    
    @Test
    void testCountNegativeElementsWithEmptyArray() {
        ArrayIntegerEntity emptyArray = arrayIntegerBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.countNegativeElements(emptyArray);
        });
    }
}
