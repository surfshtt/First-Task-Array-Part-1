package by.innowise.arraytask.specification.impl;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.specification.ArraySpecification;

import java.util.logging.Logger;

public class ContainSpecification implements ArraySpecification {
    private static final Logger logger = Logger.getLogger(ContainSpecification.class.getName());
    private final Object element;

    public ContainSpecification(Object element) {
        logger.fine("Creating ContainSpecification with element");
        this.element = element;
    }

    @Override
    public boolean specify(Object array) {
        logger.fine("Checking if array contains element");
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

