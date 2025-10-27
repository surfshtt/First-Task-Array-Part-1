package test.java.entity;

import entity.ArrayStringEntity;
import builder.ArrayStringBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ArrayStringEntityTest {
    
    private ArrayStringEntity arrayEntity;
    private String[] testArray;
    
    @BeforeEach
    void setUp() {
        testArray = new String[]{"apple", "banana", "cherry", "date", "elderberry"};
        arrayEntity = ArrayStringBuilder.create(testArray);
    }
    
    @Test
    void testCreateWithValidArray() {
        assertNotNull(arrayEntity);
        assertEquals(5, arrayEntity.getLength());
    }
    
    @Test
    void testCreateWithNullArray() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayStringBuilder.create(null);
        });
    }
    
    @Test
    void testCreateEmpty() {
        ArrayStringEntity emptyArray = ArrayStringBuilder.createEmpty(3);
        assertNotNull(emptyArray);
        assertEquals(3, emptyArray.getLength());
    }
    
    @Test
    void testCreateEmptyWithNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> {
            ArrayStringBuilder.createEmpty(-1);
        });
    }
    
    @Test
    void testGetElement() {
        assertEquals("apple", arrayEntity.getElement(0));
        assertEquals("banana", arrayEntity.getElement(1));
        assertEquals("elderberry", arrayEntity.getElement(4));
    }
    
    @Test
    void testGetElementOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.getElement(-1);
        });
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.getElement(5);
        });
    }
    
    @Test
    void testSetElement() {
        arrayEntity.setElement(0, "grape");
        assertEquals("grape", arrayEntity.getElement(0));
    }
    
    @Test
    void testSetElementOutOfBounds() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.setElement(-1, "grape");
        });
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            arrayEntity.setElement(5, "grape");
        });
    }
    
    @Test
    void testGetArrayReturnsCopy() {
        String[] originalArray = arrayEntity.getArray();
        String[] copyArray = arrayEntity.getArray();
        
        assertNotSame(originalArray, copyArray);
        assertArrayEquals(originalArray, copyArray);
        
        copyArray[0] = "modified";
        assertEquals("apple", arrayEntity.getElement(0));
    }
    
    @Test
    void testToString() {
        String result = arrayEntity.toString();
        assertTrue(result.contains("\"apple\""));
        assertTrue(result.contains("\"banana\""));
        assertTrue(result.contains("\"elderberry\""));
        assertTrue(result.startsWith("["));
        assertTrue(result.endsWith("]"));
    }
}
