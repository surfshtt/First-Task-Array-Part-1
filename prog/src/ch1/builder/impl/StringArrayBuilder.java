package ch1.builder.impl;

import ch1.array.impl.ArrayStringEntity;
import ch1.builder.ArrayBuilder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringArrayBuilder implements ArrayBuilder<String> {
    
    private final List<String> elements;
    
    private StringArrayBuilder() {
        this.elements = new ArrayList<>();
    }
    
    public static StringArrayBuilder create() {
        return new StringArrayBuilder();
    }

    public static StringArrayBuilder create(String... initialElements) {
        StringArrayBuilder builder = new StringArrayBuilder();
        return builder.addElements(Arrays.asList(initialElements));
    }

    public static StringArrayBuilder create(List<String> initialElements) {
        StringArrayBuilder builder = new StringArrayBuilder();
        return builder.addElements(initialElements);
    }
    
    @Override
    public StringArrayBuilder addElement(String element) {
        if (element != null && !element.trim().isEmpty()) {
            elements.add(element.trim());
        }
        return this;
    }
    
    @Override
    public StringArrayBuilder addElements(List<String> elements) {
        if (elements != null) {
            for (String element : elements) {
                if (element != null && !element.trim().isEmpty()) {
                    this.elements.add(element.trim());
                }
            }
        }
        return this;
    }

    @Override
    public ArrayStringEntity build() {
        return new ArrayStringEntity(new ArrayList<>(elements));
    }

    public int size() {
        return elements.size();
    }
    
    public boolean isEmpty() {
        return elements.isEmpty();
    }
}
