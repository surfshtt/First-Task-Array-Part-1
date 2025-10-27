package test.java.service;

import entity.ArrayIntegerEntity;
import entity.ArrayStringEntity;
import builder.ArrayIntegerBuilder;
import builder.ArrayStringBuilder;
import service.impl.ServiceString;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ServiceStringTest {
    
    private ServiceString service;
    private ArrayStringEntity stringArray;
    private ArrayIntegerEntity intArray;
    
    @BeforeEach
    void setUp() {
        service = new ServiceString();
        String[] testStringArray = {"apple", "banana", "cherry", "date", "elderberry"};
        int[] testIntArray = {5, -3, 8, -1, 12, 0, -7, 4};
        stringArray = ArrayStringBuilder.create(testStringArray);
        intArray = ArrayIntegerBuilder.create(testIntArray);
    }
    
    @Test
    void testFindMinValueString() {
        assertEquals("apple", service.findMinValue(stringArray));
    }
    
    @Test
    void testFindMinValueStringWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMinValue((ArrayStringEntity) null);
        });
    }
    
    @Test
    void testFindMinValueStringWithEmptyArray() {
        ArrayStringEntity emptyArray = ArrayStringBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMinValue(emptyArray);
        });
    }
    
    @Test
    void testFindMaxValueString() {
        assertEquals("elderberry", service.findMaxValue(stringArray));
    }
    
    @Test
    void testFindMaxValueStringWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMaxValue((ArrayStringEntity) null);
        });
    }
    
    @Test
    void testFindMaxValueStringWithEmptyArray() {
        ArrayStringEntity emptyArray = ArrayStringBuilder.createEmpty(0);
        assertThrows(IllegalArgumentException.class, () -> {
            service.findMaxValue(emptyArray);
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
    void testReplaceElementsStringWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            service.replaceElements((ArrayStringEntity) null, "old", "new");
        });
    }
    
    @Test
    void testUnsupportedOperationsWithIntegerArray() {
        assertThrows(UnsupportedOperationException.class, () -> {
            service.findMinValue(intArray);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            service.findMaxValue(intArray);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            service.replaceElements(intArray, 5, 10);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            service.calculateSum(intArray);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            service.calculateAverage(intArray);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            service.countPositiveElements(intArray);
        });
        
        assertThrows(UnsupportedOperationException.class, () -> {
            service.countNegativeElements(intArray);
        });
    }
}
