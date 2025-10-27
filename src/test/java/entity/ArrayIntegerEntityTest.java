package test.java.entity;

import entity.ArrayIntegerEntity;
import builder.ArrayIntegerBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class ArrayIntegerEntityTest {
    
    private ArrayIntegerEntity arrayEntity;
    private int[] testArray;
    
    @BeforeEach
    void setUp() {
        testArray = new int[]{5, -3, 8, -1, 12, 0, -7, 4};
        arrayEntity = ArrayIntegerBuilder.create(testArray);
    }
    
    @Test
    void testCreateWithValidArray() {
        assertNotNull(arrayEntity);
        assertEquals(8, arrayEntity.getLength());
    }
    
    @Test
    void testCreateWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayIntegerBuilder.create(null);
        });
    }
    
    @Test
    void testCreateEmpty() {
        ArrayIntegerEntity emptyArray = ArrayIntegerBuilder.createEmpty(5);
        assertNotNull(emptyArray);
        assertEquals(5, emptyArray.getLength());
    }
    
    @Test
    void testCreateEmptyWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayIntegerBuilder.createEmpty(-1);
        });
    }
    
    @Test
    void testGetElement() {
        assertEquals(5, arrayEntity.getElement(0));
        assertEquals(-3, arrayEntity.getElement(1));
        assertEquals(4, arrayEntity.getElement(7));
    }
    
    @Test
    void testGetElementOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.getElement(-1);
        });
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.getElement(8);
        });
    }
    
    @Test
    void testSetElement() {
        arrayEntity.setElement(0, 100);
        assertEquals(100, arrayEntity.getElement(0));
    }
    
    @Test
    void testSetElementOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.setElement(-1, 100);
        });
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.setElement(8, 100);
        });
    }
    
    @Test
    void testGetArrayReturnsCopy() {
        int[] originalArray = arrayEntity.getArray();
        int[] copyArray = arrayEntity.getArray();
        
        assertNotSame(originalArray, copyArray);
        assertArrayEquals(originalArray, copyArray);
        
        copyArray[0] = 999;
        assertEquals(5, arrayEntity.getElement(0));
    }
    
    @Test
    void testToString() {
        String result = arrayEntity.toString();
        assertTrue(result.contains("5"));
        assertTrue(result.contains("-3"));
        assertTrue(result.contains("4"));
        assertTrue(result.startsWith("["));
        assertTrue(result.endsWith("]"));
    }
}
