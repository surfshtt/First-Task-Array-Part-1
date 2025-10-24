package ch1.builder.impl;

import ch1.array.impl.ArrayIntegerEntity;
import ch1.builder.ArrayBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class IntegerArrayBuilder implements ArrayBuilder<Integer> {
    
    private final List<Integer> elements;
    
    private IntegerArrayBuilder() {
        this.elements = new ArrayList<>();
    }
    
    public static IntegerArrayBuilder create() {
        return new IntegerArrayBuilder();
    }

    public static IntegerArrayBuilder create(Integer... initialElements) {
        IntegerArrayBuilder builder = new IntegerArrayBuilder();
        return builder.addElements(Arrays.asList(initialElements));
    }

    public static IntegerArrayBuilder create(List<Integer> initialElements) {
        IntegerArrayBuilder builder = new IntegerArrayBuilder();
        return builder.addElements(initialElements);
    }
    
    @Override
    public IntegerArrayBuilder addElement(Integer element) {
        if (element != null) {
            elements.add(element);
        }
        return this;
    }
    
    @Override
    public IntegerArrayBuilder addElements(List<Integer> elements) {
        if (elements != null) {
            for (Integer element : elements) {
                if (element != null) {
                    this.elements.add(element);
                }
            }
        }
        return this;
    }
    
    @Override
    public ArrayIntegerEntity build() {
        return new ArrayIntegerEntity(new ArrayList<>(elements));
    }
    
    public int size() {
        return elements.size();
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
