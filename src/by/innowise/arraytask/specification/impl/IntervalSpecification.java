package by.innowise.arraytask.specification.impl;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.specification.ArraySpecification;

public class IntervalSpecification implements ArraySpecification {
    private final int minValue;
    private final int maxValue;

    public IntervalSpecification(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    @Override
    public boolean specify(Object array) {
        if (array instanceof ArrayIntegerEntity intEntity) {
            int[] arr = intEntity.getArray();
            for (int value : arr) {
                if (value < minValue || value > maxValue) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
}
