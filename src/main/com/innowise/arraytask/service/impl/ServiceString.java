package main.com.innowise.arraytask.service.impl;

import main.com.innowise.arraytask.entity.ArrayIntegerEntity;
import main.com.innowise.arraytask.entity.ArrayStringEntity;
import main.com.innowise.arraytask.service.ServiceInterface;

public class ServiceString implements ServiceInterface {

    @Override
    public int findMinValue(ArrayIntegerEntity array) {
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int findMaxValue(ArrayIntegerEntity array) {
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public String findMinValue(ArrayStringEntity array) {
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
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public ArrayStringEntity replaceElements(ArrayStringEntity array, String oldValue, String newValue) {
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
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int calculateSum(ArrayIntegerEntity array) {
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int countPositiveElements(ArrayIntegerEntity array) {
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
    
    @Override
    public int countNegativeElements(ArrayIntegerEntity array) {
        throw new UnsupportedOperationException("ServiceString does not support integer operations");
    }
}
