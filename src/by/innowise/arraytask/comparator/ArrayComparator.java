package by.innowise.arraytask.comparator;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;

import java.util.Comparator;

public enum ArrayComparator implements Comparator<Object> {
    HASH_CODE {
        @Override
        public int compare(Object o1, Object o2) {
            int hashCode1 = (o1 != null) ? o1.hashCode() : 0;
            int hashCode2 = (o2 != null) ? o2.hashCode() : 0;
            return Integer.compare(hashCode1, hashCode2);
        }
    },
    SUM {
        @Override
        public int compare(Object o1, Object o2) {
            int sum1 = getSum(o1);
            int sum2 = getSum(o2);
            return Integer.compare(sum1, sum2);
        }
    },
    MAX_SIZE {
        @Override
        public int compare(Object o1, Object o2) {
            int length1 = getLength(o1);
            int length2 = getLength(o2);
            return Integer.compare(length1, length2);
        }
    };

    private static int getLength(Object obj) {
        if (obj instanceof ArrayIntegerEntity intEntity) {
            return intEntity.getLength();
        } else if (obj instanceof ArrayStringEntity stringEntity) {
            return stringEntity.getLength();
        }
        return 0;
    }

    private static int getSum(Object obj) {
        if (obj instanceof ArrayIntegerEntity intEntity) {
            int[] arr = intEntity.getArray();
            int sum = 0;
            for (int value : arr) {
                sum += value;
            }
            return sum;
        } else if (obj instanceof ArrayStringEntity stringEntity) {
            String[] arr = stringEntity.getArray();
            int sum = 0;
            for (String str : arr) {
                sum += str.length();
            }
            return sum;
        }
        return 0;
    }
}
