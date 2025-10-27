package service.impl;

import entity.ArrayIntegerEntity;
import entity.ArrayStringEntity;
import service.ServiceInterface;

public class ServiceInteger implements ServiceInterface {
    
    @Override
    public int findMinValue(ArrayIntegerEntity array) {
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int[] arr = array.getArray();
        int min = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        
        return min;
    }
    
    @Override
    public int findMaxValue(ArrayIntegerEntity array) {
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int[] arr = array.getArray();
        int max = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        
        return max;
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
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        
        int[] originalArray = array.getArray();
        int[] newArray = new int[originalArray.length];
        
        for (int i = 0; i < originalArray.length; i++) {
            if (originalArray[i] == oldValue) {
                newArray[i] = newValue;
            } else {
                newArray[i] = originalArray[i];
            }
        }
        
        return new ArrayIntegerEntity(newArray);
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
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int sum = calculateSum(array);
        double average = (double) sum / array.getLength();
        
        return average;
    }
    
    @Override
    public int calculateSum(ArrayIntegerEntity array) {
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int[] arr = array.getArray();
        int sum = 0;
        
        for (int value : arr) {
            sum += value;
        }
        
        return sum;
    }
    
    @Override
    public int countPositiveElements(ArrayIntegerEntity array) {
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int[] arr = array.getArray();
        int count = 0;
        
        for (int value : arr) {
            if (value > 0) {
                count++;
            }
        }
        
        return count;
    }
    
    @Override
    public int countNegativeElements(ArrayIntegerEntity array) {
        if (array == null || array.getLength() == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty");
        }
        
        int[] arr = array.getArray();
        int count = 0;
        
        for (int value : arr) {
            if (value < 0) {
                count++;
            }
        }
        
        return count;
    }
}
