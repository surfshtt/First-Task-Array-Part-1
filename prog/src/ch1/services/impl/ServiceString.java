package ch1.services.impl;

import ch1.array.ArrayInterface;
import ch1.services.ServiceInterface;
import ch1.utils.ServiceValidator;

import java.util.List;

public class ServiceString implements ServiceInterface<String> {
    @Override
    public String findMin(ArrayInterface<String> array) {
        ServiceValidator.isValidArray(array);

        List<String> elements = array.getElements();
        String minString = elements.getFirst();
        for (String element : elements) {
            if(element.length() < minString.length()) {
                minString = element;
            }
        }

        return minString;
    }

    @Override
    public String findMax(ArrayInterface<String> array) {
        ServiceValidator.isValidArray(array);

        List<String> elements = array.getElements();
        String maxString = elements.getFirst();
        for (String element : elements) {
            if(element.length() > maxString.length()) {
                maxString = element;
            }
        }

        return maxString;
    }

    //Меняю местами элементы по индексам
    @Override
    public void replaceElements(ArrayInterface<String> array, int firstIndex, int secondIndex) {
        ServiceValidator.isValidIndex(array, firstIndex);
        ServiceValidator.isValidIndex(array, secondIndex);

        List<String> elements = array.getElements();
        String firstValue = elements.get(firstIndex);
        String secondValue = elements.get(secondIndex);
        elements.set(firstIndex, secondValue);
        elements.set(secondIndex, firstValue);
    }

    @Override
    public void replaceElement(ArrayInterface<String> array, int index, String newElement) {
        ServiceValidator.isValidIndex(array, index);

        array.getElements().set(index, newElement);
    }

    @Override
    public int averageValue(ArrayInterface<String> array) {
        ServiceValidator.isValidArray(array);

        int totalLength = sumOfElements(array);
        return totalLength / array.getElements().size();
    }

    @Override
    public int sumOfElements(ArrayInterface<String> array) {
        ServiceValidator.isValidArray(array);

        int totalLength = 0;
        for (String element : array.getElements()) {
            totalLength += element.length();
        }

        return totalLength;
    }
}
