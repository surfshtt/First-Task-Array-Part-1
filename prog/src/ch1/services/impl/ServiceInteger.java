package ch1.services.impl;

import ch1.services.ServiceInterface;

import java.util.Collections;
import java.util.List;

public class ServiceInteger implements ServiceInterface<Integer> {

    @Override
    public Integer findMin(List<Integer> elements) {
//  На случай если нельзя использовать min()
//        int min = elements.getFirst();
//        for(Integer element : elements){
//            if(element < min){
//                min = element;
//            }
//        }
        return Collections.min(elements);
    }

    @Override
    public Integer findMax(List<Integer> elements) {
        return Collections.max(elements);
    }

    //Меняю местами
    @Override
    public void replaceElements(List<Integer> elements, Integer firstIndex, Integer secondIndex) {
        int firstValue = elements.get(firstIndex);
        int secondValue = elements.get(secondIndex);
        elements.set(firstIndex, secondValue);
        elements.set(secondIndex, firstValue);
    }

    //Заменяю конкретное значение
    @Override
    public void replaceElement(List<Integer> elements, int index, Integer newElement) {
        elements.set(index, newElement);
    }

    @Override
    public int averageValue(List<Integer> elements) {
        int sum = sumOfElements(elements);

        return sum / elements.size();
    }

    @Override
    public int sumOfElements(List<Integer> elements) {
        int sum = 0;
        for(int element : elements){
            sum += element;
        }

        return sum;
    }

    public int countOfPositiveElements(List<Integer> elements){
        int count = 0;
        for(int element : elements){
            if(element > 0){
                count++;
            }
        }

        return count;
    }

    public int countOfNegativeElements(List<Integer> elements){
        int count = 0;
        for(int element : elements){
            if(element < 0){
                count++;
            }
        }

        return count;
    }
}
