package by.innowise.arraytask.sort.impl;

import by.innowise.arraytask.sort.ArraySort;

import java.util.logging.Logger;

public class ArrayInsertionSortInteger implements ArraySort<int[]> {
    private static final Logger logger = Logger.getLogger(ArrayInsertionSortInteger.class.getName());
    
    @Override
    public void sort(int[] arr) {
        logger.fine("Sorting integer array using insertion sort");
        if(arr == null || arr.length == 0) {
            return;
        }

        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
}
