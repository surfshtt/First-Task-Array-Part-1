package main.com.innowise.arraytask.sort.impl;

import main.com.innowise.arraytask.sort.ArraySort;

public class ArrayInsertionSortInteger implements ArraySort<int[]> {
    @Override
    public void sort(int[] arr) {
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
