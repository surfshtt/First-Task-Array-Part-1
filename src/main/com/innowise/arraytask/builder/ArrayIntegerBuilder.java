package main.com.innowise.arraytask.builder;

import main.com.innowise.arraytask.entity.ArrayIntegerEntity;

public class ArrayIntegerBuilder {
    public ArrayIntegerEntity create(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return new ArrayIntegerEntity(array);
    }

    public ArrayIntegerEntity createEmpty(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        return new ArrayIntegerEntity(new int[size]);
    }
}
