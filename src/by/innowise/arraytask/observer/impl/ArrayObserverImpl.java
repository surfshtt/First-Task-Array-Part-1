package by.innowise.arraytask.observer.impl;

import by.innowise.arraytask.entity.ArrayIntegerEntity;
import by.innowise.arraytask.entity.ArrayStringEntity;
import by.innowise.arraytask.observer.ArrayObserver;
import by.innowise.arraytask.service.ServiceInterface;
import by.innowise.arraytask.service.impl.ServiceInteger;
import by.innowise.arraytask.warehouse.ArrayWarehouse;

public class ArrayObserverImpl implements ArrayObserver {
    private final ArrayWarehouse warehouse;
    private final ServiceInterface service;

    public ArrayObserverImpl() {
        this.warehouse = ArrayWarehouse.getInstance();
        this.service = new ServiceInteger();
    }

    @Override
    public void handleEvent(Object array) {
        if (array == null) {
            return;
        }

        ArrayParameters parameters = calculateParameters(array);
        warehouse.putArrayParameters(array.hashCode(), parameters);
    }

    private ArrayParameters calculateParameters(Object array) {
        if (array instanceof ArrayIntegerEntity intEntity) {
            int minValue = service.findMinValue(intEntity);
            int maxValue = service.findMaxValue(intEntity);
            double averageValue = service.calculateAverage(intEntity);
            int arraySum = service.calculateSum(intEntity);
            int positiveValuesCount = service.countPositiveElements(intEntity);
            int negativeValuesCount = service.countNegativeElements(intEntity);

            return new ArrayParameters(
                    intEntity.hashCode(),
                    String.valueOf(minValue),
                    String.valueOf(maxValue),
                    averageValue,
                    arraySum,
                    positiveValuesCount,
                    negativeValuesCount
            );
        } else if (array instanceof ArrayStringEntity stringEntity) {
            String minValue = service.findMinValue(stringEntity);
            String maxValue = service.findMaxValue(stringEntity);
            return new ArrayParameters(
                    stringEntity.hashCode(),
                    minValue,
                    maxValue,
                    0.0,
                    0,
                    0,
                    0
            );
        }
        
        throw new IllegalArgumentException("Unsupported array type");
    }

    public static class ArrayParameters {
        private final int arrayId;
        private final String minValue;
        private final String maxValue;
        private final double averageValue;
        private final int arraySum;
        private final int positiveValuesCount;
        private final int negativeValuesCount;

        public ArrayParameters(int arrayId, String minValue, String maxValue, double averageValue, int arraySum, int positiveValuesCount, int negativeValuesCount) {
            this.arrayId = arrayId;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.averageValue = averageValue;
            this.arraySum = arraySum;
            this.positiveValuesCount = positiveValuesCount;
            this.negativeValuesCount = negativeValuesCount;
        }

        public int getArrayId() { return arrayId; }
        public String getMinValue() { return minValue; }
        public String getMaxValue() { return maxValue; }
        public double getAverageValue() { return averageValue; }
        public int getArraySum() { return arraySum; }
        public int getPositiveValuesCount() { return positiveValuesCount; }
        public int getNegativeValuesCount() { return negativeValuesCount; }
    }
}
