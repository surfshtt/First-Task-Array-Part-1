package service;

import entity.ArrayIntegerEntity;
import entity.ArrayStringEntity;

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
