package ch1.service;

import ch1.array.ArrayInterface;

public interface ServiceInterface<T> {
    T findMin(ArrayInterface<T> array);
    T findMax(ArrayInterface<T> array);
    void replaceElements(ArrayInterface<T> array, int firstIndex, int secondIndex);
    void replaceElement(ArrayInterface<T> array, int index, T newElement);
    int averageValue(ArrayInterface<T> array);
    int sumOfElements(ArrayInterface<T> array);
}
