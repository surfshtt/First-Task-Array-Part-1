package by.innowise.arraytask.service.impl;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.service.ServiceInterface;

import java.util.logging.Logger;

public class ServiceString implements ServiceInterface {
    private static final Logger logger = Logger.getLogger(ServiceString.class.getName());

    @Override
    public int findMinValue(ArrayIntegerEntity array) {
        logger.warning("Unsupported operation: findMinValue for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int findMaxValue(ArrayIntegerEntity array) {
        logger.warning("Unsupported operation: findMaxValue for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public String findMinValue(ArrayStringEntity array) {
        logger.fine("Finding minimum value in string array");
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        String[] arr = array.getArray();
        String min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(min) < 0) {
                min = arr[i];
            }
        }
        
        return min;
    }
    
    @Override
    public String findMaxValue(ArrayStringEntity array) {
        logger.fine("Finding maximum value in string array");
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        String[] arr = array.getArray();
        String max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].compareTo(max) > 0) {
                max = arr[i];
            }
        }
        
        return max;
    }
    
    @Override
    public ArrayIntegerEntity replaceElements(ArrayIntegerEntity array, int oldValue, int newValue) {
        logger.warning("Unsupported operation: replaceElements for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public ArrayStringEntity replaceElements(ArrayStringEntity array, String oldValue, String newValue) {
        logger.fine("Replacing elements in string array");
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        String[] originalArray = array.getArray();
        String[] newArray = new String[originalArray.length];
        
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i].equals(oldValue)) {
                newArray[i] = newValue;
            } else {
                newArray[i] = originalArray[i];
            }
        }
        
        return new ArrayStringEntity(newArray);
    }
    
    @Override
    public double calculateAverage(ArrayIntegerEntity array) {
        logger.warning("Unsupported operation: calculateAverage for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int calculateSum(ArrayIntegerEntity array) {
        logger.warning("Unsupported operation: calculateSum for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int countPositiveElements(ArrayIntegerEntity array) {
        logger.warning("Unsupported operation: countPositiveElements for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int countNegativeElements(ArrayIntegerEntity array) {
        logger.warning("Unsupported operation: countNegativeElements for integer array");
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
}
