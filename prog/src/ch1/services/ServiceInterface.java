package ch1.services;

import java.util.List;

public interface ServiceInterface<T> {
    T findMin(List<T> elements);
    T findMax(List<T> elements);
    void replaceElements(List<T> elements, T firstIndex, T secondIndex);
    void replaceElement(List<T> elements, int index, T newElement);
    int averageValue(List<T> elements);
    int sumOfElements(List<T> elements);
}
