package by.innowise.arraytask.specification.impl;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.specification.ArraySpecification;

public class ContainSpecification implements ArraySpecification {
    private final Object element;

    public ContainSpecification(Object element) {
        this.element = element;
    }

    @Override
    public boolean specify(Object array) {
        if (array instanceof ArrayIntegerEntity intEntity && element instanceof Integer) {
            int[] arr = intEntity.getArray();
            int target = (Integer) element;
            for (int value : arr) {
                if (value == target) {
                    return true;
                }
            }
        } else if (array instanceof ArrayStringEntity stringEntity && element instanceof String) {
            String[] arr = stringEntity.getArray();
            String target = (String) element;
            for (String str : arr) {
                if (str.equals(target)) {
                    return true;
                }
            }
        }
        return false;
    }
}
