package builder;

import entity.ArrayIntegerEntity;

public class ArrayIntegerBuilder {
    public static ArrayIntegerEntity create(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return new ArrayIntegerEntity(array);
    }

    public static ArrayIntegerEntity createEmpty(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        return new ArrayIntegerEntity(new int[size]);
    }
}
