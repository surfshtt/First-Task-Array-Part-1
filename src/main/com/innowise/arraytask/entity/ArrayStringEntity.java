package main.com.innowise.arraytask.entity;

import main.com.innowise.arraytask.builder.ArrayStringBuilder;

public class ArrayStringEntity {
    private final String[] array;
    
    public ArrayStringEntity(String[] array) {
        this.array = array.clone();
    }
    
    public String[] getArray() {
        return array.clone();
    }
    
    public int getLength() {
        return array.length;
    }
    
    public String getElement(int index) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        return array[index];
    }
    
    public void setElement(int index, String value) {
        if (index < 0 || index >= array.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + array.length);
        }
        array[index] = value;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            sb.append("\"").append(array[i]).append("\"");
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

        ArrayStringEntity that = (ArrayStringEntity) obj;
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
        for (String j : array) {
            hash = 31 * hash + j.length();
        }
        return hash;
    }
}
