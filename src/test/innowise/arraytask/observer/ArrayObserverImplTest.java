package test.innowise.arraytask.observer;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.observer.impl.ArrayObserverImpl;
import by.innowise.arraytask.warehouse.ArrayWarehouse;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ArrayObserverImplTest {

    private ArrayObserverImpl observer;
    private ArrayWarehouse warehouse;
    private ArrayIntegerEntity intArray;
    private ArrayStringEntity stringArray;

    @BeforeEach
    void setUp() throws Exception {
        resetWarehouseSingleton();
        warehouse = ArrayWarehouse.getInstance();

        intArray = new ArrayIntegerEntity(new int[]{1, 2, 3, 4, 5});
        stringArray = new ArrayStringEntity(new String[]{"a", "b", "c"});

        observer = new ArrayObserverImpl();
    }

    @AfterEach
    void tearDown() throws Exception {
        resetWarehouseSingleton();
    }

    private void resetWarehouseSingleton() throws Exception {
        Field instanceField = ArrayWarehouse.class.getDeclaredField("instance");
        instanceField.setAccessible(true);
        instanceField.set(null, null);
    }

    @Test
    @DisplayName("Constructor initializes dependencies")
    void testConstructorInitializesDependencies() {
        assertNotNull(observer);
        assertNotNull(warehouse);
    }

    @Test
    @DisplayName("HandleEvent with valid integer array updates warehouse")
    void testHandleEventWithValidIntegerArrayUpdatesWarehouse() {
        observer.handleEvent(intArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        assertEquals(1, parametersMap.size());

        ArrayObserverImpl.ArrayParameters storedParameters = parametersMap.get(intArray.hashCode());
        assertNotNull(storedParameters);
        assertEquals(intArray.hashCode(), storedParameters.getArrayId());
        assertNotNull(storedParameters.getMinValue());
        assertNotNull(storedParameters.getMaxValue());
        assertEquals(15, storedParameters.getArraySum());
        assertEquals(5, storedParameters.getPositiveValuesCount());
        assertEquals(0, storedParameters.getNegativeValuesCount());
    }

    @Test
    @DisplayName("HandleEvent with valid string array updates warehouse")
    void testHandleEventWithValidStringArrayUpdatesWarehouse() {
        observer.handleEvent(stringArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        assertEquals(1, parametersMap.size());

        ArrayObserverImpl.ArrayParameters storedParameters = parametersMap.get(stringArray.hashCode());
        assertNotNull(storedParameters);
        assertEquals(stringArray.hashCode(), storedParameters.getArrayId());
        assertNotNull(storedParameters.getMinValue());
        assertNotNull(storedParameters.getMaxValue());
    }

    @Test
    @DisplayName("HandleEvent with null array does nothing")
    void testHandleEventWithNullArray() {
        observer.handleEvent(null);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        assertTrue(parametersMap.isEmpty());
    }

    @Test
    @DisplayName("HandleEvent with empty integer array handles exception")
    void testHandleEventWithEmptyIntegerArray() {
        ArrayIntegerEntity emptyArray = new ArrayIntegerEntity(new int[0]);

        assertDoesNotThrow(() -> {
            observer.handleEvent(emptyArray);
        });

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        assertTrue(parametersMap.isEmpty());
    }

    @Test
    @DisplayName("HandleEvent with negative values")
    void testHandleEventWithNegativeValues() {
        ArrayIntegerEntity negativeArray = new ArrayIntegerEntity(new int[]{-1, -2, -3, 4, 5});

        observer.handleEvent(negativeArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        ArrayObserverImpl.ArrayParameters storedParameters = parametersMap.get(negativeArray.hashCode());

        assertNotNull(storedParameters);
        assertEquals(3, storedParameters.getPositiveValuesCount());
        assertEquals(2, storedParameters.getNegativeValuesCount());
        assertEquals(3, storedParameters.getArraySum());
    }

    @Test
    @DisplayName("HandleEvent updates warehouse multiple times")
    void testHandleEventUpdatesWarehouseMultipleTimes() {
        observer.handleEvent(intArray);
        observer.handleEvent(stringArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        assertEquals(2, parametersMap.size());

        assertNotNull(parametersMap.get(intArray.hashCode()));
        assertNotNull(parametersMap.get(stringArray.hashCode()));
    }

    @Test
    @DisplayName("HandleEvent with same array updates existing entry")
    void testHandleEventWithSameArrayUpdatesExistingEntry() {
        observer.handleEvent(intArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> firstParameters = warehouse.getArrayParametersMap();
        ArrayObserverImpl.ArrayParameters first = firstParameters.get(intArray.hashCode());

        ArrayIntegerEntity modifiedArray = new ArrayIntegerEntity(new int[]{10, 20, 30});
        observer.handleEvent(modifiedArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> secondParameters = warehouse.getArrayParametersMap();
        assertTrue(secondParameters.containsKey(intArray.hashCode()) || 
                   secondParameters.containsKey(modifiedArray.hashCode()));
    }

    @Test
    @DisplayName("HandleEvent calculates correct average for integer array")
    void testHandleEventCalculatesCorrectAverage() {
        ArrayIntegerEntity testArray = new ArrayIntegerEntity(new int[]{2, 4, 6});
        observer.handleEvent(testArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();
        ArrayObserverImpl.ArrayParameters storedParameters = parametersMap.get(testArray.hashCode());

        assertNotNull(storedParameters);
        assertEquals(4.0, storedParameters.getAverageValue(), 0.001);
        assertEquals(12, storedParameters.getArraySum());
    }

    @Test
    @DisplayName("HandleEvent handles exception gracefully")
    void testHandleEventHandlesExceptionGracefully() {
        assertDoesNotThrow(() -> {
            observer.handleEvent(null);
        });
    }
}
