package main.com.innowise.arraytask.entity;

public class ArrayIntegerEntity {
    private final int[] array;

    public ArrayIntegerEntity(int[] array) {
        this.array = array.clone();
    }
    
    public int[] getArray() {
        return array.clone();
    }
    
    public int getLength() {
        return array.length;
    }
    
    public int getElement(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        return array[index];
    }
    
    public void setElement(int index, int value) {
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
}
