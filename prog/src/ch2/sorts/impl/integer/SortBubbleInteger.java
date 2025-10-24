package ch2.sorts.impl.integer;

import ch1.array.ArrayInterface;
import ch2.sorts.SortInterface;

import java.util.List;

public class SortBubbleInteger implements SortInterface<Integer> {
    @Override
    public void sort(ArrayInterface<Integer> array) {
        List<Integer> arr = array.getElements();
        boolean swapped;

        for (int i = 0; i < arr.size() - 1; i++) {
            swapped = false;
            for (int j = 0; j < arr.size() - 1 - i; j++) {
                if (arr.get(j) > arr.get(j + 1)) {
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    swapped = true;
                }
            }

            if (!swapped) break;
        }
    }
}
