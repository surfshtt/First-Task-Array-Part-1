package by.innowise.arraytask.builder;

import by.innowise.arraytask.entity.ArrayStringEntity;

import java.util.logging.Logger;

public class ArrayStringBuilder {
    private static final Logger logger = Logger.getLogger(ArrayStringBuilder.class.getName());
    
    public ArrayStringEntity create(String[] array) {
        logger.info("Creating ArrayStringEntity from array");
        if (array == null) {
            throw new IllegalArgumentException("Array cannot be null");
        }
        return new ArrayStringEntity(array);
    }

    public ArrayStringEntity createEmpty(int size) {
        logger.fine("Creating empty ArrayStringEntity with size: " + size);
        if (size < 0) {
            throw new IllegalArgumentException("Size cannot be negative");
        }
        return new ArrayStringEntity(new String[size]);
    }
}
