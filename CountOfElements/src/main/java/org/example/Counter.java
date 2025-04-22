package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Counter<T> {

    Integer newValue;

    public Map<T, Integer> count(ArrayList<T> arrayList){
        Map <T, Integer> resultMap = new HashMap<>();
        for (T element : arrayList){
            if (!resultMap.containsKey(element)){
                resultMap.put(element, 1);
            } else {
                newValue = resultMap.get(element) + 1;
                resultMap.replace(element, newValue);
            }

        }
        return resultMap;
    }
}
