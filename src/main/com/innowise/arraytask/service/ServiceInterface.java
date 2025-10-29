package main.com.innowise.arraytask.service;

import main.com.innowise.arraytask.entity.ArrayIntegerEntity;
import main.com.innowise.arraytask.entity.ArrayStringEntity;

public interface ServiceInterface {
    
    int findMinValue(ArrayIntegerEntity array);
    
    int findMaxValue(ArrayIntegerEntity array);
    
    String findMinValue(ArrayStringEntity array);
    
    String findMaxValue(ArrayStringEntity array);
    
    ArrayIntegerEntity replaceElements(ArrayIntegerEntity array, int oldValue, int newValue);
    
    ArrayStringEntity replaceElements(ArrayStringEntity array, String oldValue, String newValue);
    
    double calculateAverage(ArrayIntegerEntity array);
    
    int calculateSum(ArrayIntegerEntity array);
    
    int countPositiveElements(ArrayIntegerEntity array);
    
    int countNegativeElements(ArrayIntegerEntity array);
}
