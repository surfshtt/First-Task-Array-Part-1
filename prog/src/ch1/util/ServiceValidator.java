package ch1.util;

import ch1.array.ArrayInterface;
import java.util.List;

public class ServiceValidator {
    public static <T> void isValidArray(ArrayInterface<T> array) {
        if(array == null){
            throw new IllegalArgumentException("Array is null");
        }
        if(array.getElements() == null){
            throw new IllegalArgumentException("Array elements are null");
        }
        if(array.getElements().isEmpty()){
            throw new IllegalArgumentException("Array is empty");
        }
    }

    public static <T> void isValidIndex(ArrayInterface<T> array, int index) {
        isValidArray(array);
        List<T> elements = array.getElements();
        if(index >= elements.size()){
            throw new IndexOutOfBoundsException("Index is out of bounds");
        }

        if(index < 0){
            throw new IndexOutOfBoundsException("Index is negative");
        }
    }
}
