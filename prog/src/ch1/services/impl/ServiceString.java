package ch1.services.impl;

import ch1.services.ServiceInterface;

import java.util.List;

public class ServiceString implements ServiceInterface<String> {
    @Override
    public String findMin(List<String> elements) {
        String minString = elements.getFirst();
        for (String element : elements) {
            if(element.length() < minString.length()) {
                minString = element;
            }
        }

        return minString;
    }

    @Override
    public String findMax(List<String> elements) {
        String maxString = elements.getFirst();
        for (String element : elements) {
            if(element.length() > maxString.length()) {
                maxString = element;
            }
        }

        return maxString;
    }

    //Тут поиск не по индексу переданному, в качестве параметра саму строку кидаю
    @Override
    public void replaceElements(List<String> elements, String firstElement, String secondElement) {
        int firstIndex = elements.indexOf(firstElement);
        int secondIndex = elements.indexOf(secondElement);
        elements.set(firstIndex, secondElement);
        elements.set(secondIndex, firstElement);
    }

    @Override
    public void replaceElement(List<String> elements, int index, String newElement) {
        elements.set(index, newElement);
    }

    @Override
    public int averageValue(List<String> elements) {
        int totalLength = sumOfElements(elements);

        return totalLength / elements.size();
    }

    @Override
    public int sumOfElements(List<String> elements) {
        int totalLength = 0;
        for (String element : elements) {
            totalLength += element.length();
        }

        return totalLength;
    }
}
