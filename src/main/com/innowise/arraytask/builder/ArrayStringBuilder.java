package main.com.innowise.arraytask.builder;

import main.com.innowise.arraytask.entity.ArrayStringEntity;

public class ArrayStringBuilder {
    public ArrayStringEntity create(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return new ArrayStringEntity(array);
    }

    public ArrayStringEntity createEmpty(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        return new ArrayStringEntity(new String[size]);
    }
}
