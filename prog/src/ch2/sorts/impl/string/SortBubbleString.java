package ch2.sorts.impl.string;

import ch1.array.ArrayInterface;
import ch2.sorts.SortInterface;

import java.util.List;

public class SortBubbleString implements SortInterface<String> {
    @Override
    public void sort(ArrayInterface<String> array) {
        List<String> arr = array.getElements();
        boolean swapped;

        for (int i = 0; i < arr.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j).length() > arr.get(j + 1).length()) {
                    String temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
