package by.innowise.arraytask.sort.impl;

import by.innowise.arraytask.sort.ArraySort;

import java.util.logging.Logger;

public class ArrayBubbleSortString implements ArraySort<String[]> {
    private static final Logger logger = Logger.getLogger(ArrayBubbleSortString.class.getName());
    
    @Override
    public void sort(String[] array) {
        logger.fine("Sorting string array using bubble sort");
        if(array == null || array.length == 0) {
            return;
        }

        int n = array.length;
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (array[j].length() > array[j + 1].length()) {
                    String temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
