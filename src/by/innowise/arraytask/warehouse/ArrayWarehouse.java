package by.innowise.arraytask.warehouse;

import by.innowise.arraytask.observer.impl.ArrayObserverImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

public class ArrayWarehouse {
    private static final Logger logger = Logger.getLogger(ArrayWarehouse.class.getName());
    private static ArrayWarehouse instance;
    private final Map<Integer, ArrayObserverImpl.ArrayParameters> arrayParametersMap = new HashMap<>();

    private ArrayWarehouse() {
        logger.info("Creating ArrayWarehouse instance");
    }

    public static ArrayWarehouse getInstance() {
        logger.fine("Getting ArrayWarehouse instance");
        if (instance == null) {
            instance = new ArrayWarehouse();
        }
        return instance;
    }

    public Map<Integer, ArrayObserverImpl.ArrayParameters> getArrayParametersMap() {
        logger.fine("Getting all array parameters");
        return Map.copyOf(arrayParametersMap);
    }

    public ArrayObserverImpl.ArrayParameters getArrayParameters(int id) {
        logger.fine("Getting array parameters for id: " + id);
        return arrayParametersMap.get(id);
    }

    public void putArrayParameters(int id, ArrayObserverImpl.ArrayParameters arrayParameters) {
        logger.info("Storing array parameters for id: " + id);
        if (arrayParameters == null) {
            throw new IllegalArgumentException("Warehouse: arrayParameter cannot be null");
        }
        arrayParametersMap.put(id, arrayParameters);
    }
}

