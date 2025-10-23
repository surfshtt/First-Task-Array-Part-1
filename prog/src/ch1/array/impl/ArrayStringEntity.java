package ch1.array.impl;

import ch1.array.ArrayInterface;

import java.util.List;

public class ArrayStringEntity implements ArrayInterface<String> {
    private final List<String> elements;

    public ArrayStringEntity(List<String> elements) {
        this.elements = elements;
    }

    @Override
    public List<String> getElements() {
        return elements;
    }
}
