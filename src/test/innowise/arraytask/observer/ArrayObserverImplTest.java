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
        warehouse = ArrayWarehouse.getInstance();

        intArray = new ArrayIntegerEntity(new int[]{1, 2, 3, 4, 5});
        stringArray = new ArrayStringEntity(new String[]{"a", "b", "c"});

        observer = new ArrayObserverImpl();
    }

    @Test
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
    void testHandleEventWithNullArray() {
        observer.handleEvent(null);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();

        assertTrue(parametersMap.isEmpty());
    }

    @Test
    void testHandleEventUpdatesWarehouseMultipleTimes() {
        observer.handleEvent(intArray);
        observer.handleEvent(stringArray);

        Map<Integer, ArrayObserverImpl.ArrayParameters> parametersMap = warehouse.getArrayParametersMap();

        assertEquals(2, parametersMap.size());
        assertNotNull(parametersMap.get(intArray.hashCode()));
        assertNotNull(parametersMap.get(stringArray.hashCode()));
    }
}
