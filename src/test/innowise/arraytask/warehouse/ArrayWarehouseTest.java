package test.innowise.arraytask.warehouse;

import by.innowise.arraytask.observer.impl.ArrayObserverImpl;
import by.innowise.arraytask.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArrayWarehouseTest {

    private ArrayWarehouse warehouse;
    private ArrayObserverImpl.ArrayParameters testParameters1;
    private ArrayObserverImpl.ArrayParameters testParameters2;

    @BeforeEach
    void setUp() throws Exception {
        resetSingleton();
        warehouse = ArrayWarehouse.getInstance();

        testParameters1 = new ArrayObserverImpl.ArrayParameters(
                1, "minValue1", "maxValue1", 10.5, 100, 5, 3
        );

        testParameters2 = new ArrayObserverImpl.ArrayParameters(
                2, "minValue2", "maxValue2", 20.5, 200, 8, 2
        );
    }

    @AfterEach
    void tearDown() throws Exception {
        resetSingleton();
    }

    private void resetSingleton() throws Exception {
        Field instanceField = ArrayWarehouse.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
    }

    @Test
    void testGetInstanceReturnsSameInstance() {
        ArrayWarehouse instance1 = ArrayWarehouse.getInstance();
        ArrayWarehouse instance2 = ArrayWarehouse.getInstance();

        assertSame(instance1, instance2);
    }

    @Test
    @DisplayName("GetInstance creates new instance only once")
    void testGetInstanceCreatesInstanceOnlyOnce() throws Exception {
        ArrayWarehouse instance1 = ArrayWarehouse.getInstance();
        ArrayWarehouse instance2 = ArrayWarehouse.getInstance();

        assertSame(instance1, instance2);

        resetSingleton();
        ArrayWarehouse instance3 = ArrayWarehouse.getInstance();

        assertNotSame(instance1, instance3);
    }

    @Test
    @DisplayName("GetArrayParametersMap returns empty map for new warehouse")
    void testGetArrayParametersMapReturnsEmptyMapForNewWarehouse() {
        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();

        assertNotNull(result);
        assertTrue(result.isEmpty());
        assertEquals(0, result.size());
    }

    @Test
    @DisplayName("GetArrayParametersMap returns copy of internal map")
    void testGetArrayParametersMapReturnsCopy() {
        warehouse.putArrayParameters(1, testParameters1);

        Map<Integer, ArrayObserverImpl.ArrayParameters> copy1 = warehouse.getArrayParametersMap();
        Map<Integer, ArrayObserverImpl.ArrayParameters> copy2 = warehouse.getArrayParametersMap();

        assertNotSame(copy1, copy2);
        assertEquals(copy1, copy2);
        assertEquals(1, copy1.size());
        assertEquals(testParameters1, copy1.get(1));
    }

    @Test
    @DisplayName("GetArrayParametersMap returns immutable map")
    void testGetArrayParametersMapReturnsImmutableMap() {
        warehouse.putArrayParameters(1, testParameters1);
        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();

        assertThrows(UnsupportedOperationException.class, () -> {
            result.put(2, testParameters2);
        });
    }

    @Test
    @DisplayName("PutArrayParameters adds parameters to warehouse")
    void testPutArrayParametersAddsParameters() {
        warehouse.putArrayParameters(1, testParameters1);

        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();
        assertEquals(1, result.size());
        assertEquals(testParameters1, result.get(1));
    }

    @Test
    @DisplayName("PutArrayParameters with multiple entries")
    void testPutArrayParametersMultipleEntries() {
        warehouse.putArrayParameters(1, testParameters1);
        warehouse.putArrayParameters(2, testParameters2);

        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();
        assertEquals(2, result.size());
        assertEquals(testParameters1, result.get(1));
        assertEquals(testParameters2, result.get(2));
    }

    @Test
    @DisplayName("PutArrayParameters updates existing entry")
    void testPutArrayParametersUpdatesExistingEntry() {
        warehouse.putArrayParameters(1, testParameters1);

        ArrayObserverImpl.ArrayParameters updatedParameters = new ArrayObserverImpl.ArrayParameters(
                1, "updatedMin", "updatedMax", 15.0, 150, 10, 5
        );

        warehouse.putArrayParameters(1, updatedParameters);

        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();
        assertEquals(1, result.size());
        assertEquals(updatedParameters, result.get(1));
    }

    @Test
    @DisplayName("PutArrayParameters with null throws exception")
    void testPutArrayParametersWithNullThrowsException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            warehouse.putArrayParameters(1, null);
        });

        assertEquals("Warehouse: arrayParameter cannot be null", exception.getMessage());

        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();
        assertTrue(result.isEmpty());
    }

    @Test
    @DisplayName("PutArrayParameters with negative id")
    void testPutArrayParametersWithNegativeId() {
        warehouse.putArrayParameters(-1, testParameters1);

        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();
        assertEquals(1, result.size());
        assertEquals(testParameters1, result.get(-1));
    }

    @Test
    @DisplayName("PutArrayParameters with zero id")
    void testPutArrayParametersWithZeroId() {
        warehouse.putArrayParameters(0, testParameters1);

        Map<Integer, ArrayObserverImpl.ArrayParameters> result = warehouse.getArrayParametersMap();
        assertEquals(1, result.size());
        assertEquals(testParameters1, result.get(0));
    }

    @Test
    @DisplayName("GetArrayParameters returns stored parameters")
    void testGetArrayParametersReturnsStoredParameters() {
        warehouse.putArrayParameters(1, testParameters1);

        ArrayObserverImpl.ArrayParameters result = warehouse.getArrayParameters(1);

        assertNotNull(result);
        assertEquals(testParameters1, result);
    }

    @Test
    @DisplayName("GetArrayParameters returns null for non-existent id")
    void testGetArrayParametersReturnsNullForNonExistentId() {
        ArrayObserverImpl.ArrayParameters result = warehouse.getArrayParameters(999);
        assertNull(result);
    }
}
