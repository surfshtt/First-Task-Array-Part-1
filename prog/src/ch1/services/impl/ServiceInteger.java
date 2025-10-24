package ch1.services.impl;

import ch1.array.ArrayInterface;
import ch1.services.ServiceInterface;
import ch1.utils.ServiceValidator;

import java.util.Collections;
import java.util.List;

public class ServiceInteger implements ServiceInterface<Integer> {

    @Override
    public Integer findMin(ArrayInterface<Integer> array) {
        ServiceValidator.isValidArray(array);

        return Collections.min(array.getElements());
    }

    @Override
    public Integer findMax(ArrayInterface<Integer> array) {
        ServiceValidator.isValidArray(array);

        return Collections.max(array.getElements());
    }

    //Меняю местами элементы по индексам
    @Override
    public void replaceElements(ArrayInterface<Integer> array, int firstIndex, int secondIndex) {
        ServiceValidator.isValidIndex(array, firstIndex);
        ServiceValidator.isValidIndex(array, secondIndex);

        List<Integer> elements = array.getElements();
        int firstValue = elements.get(firstIndex);
        int secondValue = elements.get(secondIndex);
        elements.set(firstIndex, secondValue);
        elements.set(secondIndex, firstValue);
    }

    //Заменяю конкретное значение по индексу
    @Override
    public void replaceElement(ArrayInterface<Integer> array, int index, Integer newElement) {
        ServiceValidator.isValidIndex(array, index);

        array.getElements().set(index, newElement);
    }

    @Override
    public int averageValue(ArrayInterface<Integer> array) {
        ServiceValidator.isValidArray(array);

        int sum = sumOfElements(array);
        return sum / array.getElements().size();
    }

    @Override
    public int sumOfElements(ArrayInterface<Integer> array) {
        ServiceValidator.isValidArray(array);

        int sum = 0;
        for(int element : array.getElements()){
            sum += element;
        }

        return sum;
    }

    public int countOfPositiveElements(ArrayInterface<Integer> array){
        ServiceValidator.isValidArray(array);

        int count = 0;
        for(int element : array.getElements()){
            if(element > 0){
                count++;
            }
        }

        return count;
    }

    public int countOfNegativeElements(ArrayInterface<Integer> array){
        ServiceValidator.isValidArray(array);

        int count = 0;
        for(int element : array.getElements()){
            if(element < 0){
                count++;
            }
        }

        return count;
    }
}
