package builder;

import entity.ArrayStringEntity;

public class ArrayStringBuilder {
    public static ArrayStringEntity create(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return new ArrayStringEntity(array);
    }

    public static ArrayStringEntity createEmpty(int size) {
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        return new ArrayStringEntity(new String[size]);
    }
}
