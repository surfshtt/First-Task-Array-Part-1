package ch1.builder;

import ch1.array.ArrayInterface;

import java.util.List;

public interface ArrayBuilder<T> {
    ArrayBuilder<T> addElement(T element);
    ArrayBuilder<T> addElements(List<T> elements);
    ArrayInterface<T> build();
}
