package by.innowise.arraytask.entity;

import java.util.logging.Logger;

public class ArrayIntegerEntity {
    private static final Logger logger = Logger.getLogger(ArrayIntegerEntity.class.getName());
    private final int[] array;

    public ArrayIntegerEntity(int[] array) {
        logger.info("Creating ArrayIntegerEntity");
        this.array = array.clone();
    }
    
    public int[] getArray() {
        logger.fine("Getting array copy");
        return array.clone();
    }
    
    public int getLength() {
        logger.fine("Getting array length");
        return array.length;
    }
    
    public int getElement(int index) {
        logger.fine("Getting element at index: " + index);
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return array[index];
    }
    
    public void setElement(int index, int value) {
        logger.fine("Setting element at index: " + index);
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        array[index] = value;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append(array[i]);
            if (i < array.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null || getClass() != obj.getClass()) {
            return false;
        }

        ArrayIntegerEntity that = (ArrayIntegerEntity) obj;
        if(that.getLength() != array.length) {
            return false;
        }

        for (int i = 0; i < array.length; i++) {
            if(array[i] != that.array[i]) {
                return false;
            }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        for (int j : array) {
            hash = 31 * hash + j;
        }
        return hash;
    }
}
