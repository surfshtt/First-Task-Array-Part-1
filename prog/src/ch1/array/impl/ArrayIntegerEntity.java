package ch1.array.impl;

import ch1.array.ArrayInterface;

import java.util.List;

public class ArrayIntegerEntity implements ArrayInterface<Integer> {

    private final List<Integer> elements;

    public ArrayIntegerEntity(List<Integer> elements) {
        this.elements = elements;
    }

    @Override
    public List<Integer> getElements() {
        return elements;
    }
}
