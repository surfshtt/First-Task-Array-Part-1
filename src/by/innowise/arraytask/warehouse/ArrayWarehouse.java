package by.innowise.arraytask.warehouse;

import by.innowise.arraytask.observer.impl.ArrayObserverImpl;

import java.util.HashMap;
import java.util.Map;

public class ArrayWarehouse {
    private static ArrayWarehouse instance;
    private final Map<Integer, ArrayObserverImpl.ArrayParameters> arrayParametersMap = new HashMap<>();

    private ArrayWarehouse() {}

    public static ArrayWarehouse getInstance() {
        if (instance == null) {
            instance = new ArrayWarehouse();
        }
        return instance;
    }

    public Map<Integer, ArrayObserverImpl.ArrayParameters> getArrayParametersMap() {
        return Map.copyOf(arrayParametersMap);
    }

    public ArrayObserverImpl.ArrayParameters getArrayParameters(int id) {
        return arrayParametersMap.get(id);
    }

    public void putArrayParameters(int id, ArrayObserverImpl.ArrayParameters arrayParameters) {
        if (arrayParameters == null) {
            throw new IllegalArgumentException("Warehouse: arrayParameter cannot be null");
        }
        arrayParametersMap.put(id, arrayParameters);
    }
}
