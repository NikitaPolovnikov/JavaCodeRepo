package org.example;

import java.util.*;

public class Main {

<<<<<<< Updated upstream
    static ArrayList<Object> arrayList = new ArrayList<>();
    static Map <Object, Integer> resultMap = new HashMap<>();
    static Integer newValue;

    public Map<Object, Integer> counter(ArrayList<Object> arrayList){
        for (Object element : arrayList){
            if (!resultMap.containsKey(element)){
                resultMap.put(element, 1);
            } else {
                newValue = resultMap.get(element) + 1;
                resultMap.replace(element, newValue);
            }

        }
        return resultMap;
    }

    public static void main(String[] args) {
=======
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>();
        Counter counter = new Counter();

>>>>>>> Stashed changes
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(2);
        arrayList.add(66);
        arrayList.add(8);
        arrayList.add(66);
        arrayList.add(1);

<<<<<<< Updated upstream
        Main test = new Main();
        test.counter(arrayList);
        System.out.println(resultMap);
=======
       System.out.println(counter.count(arrayList));
>>>>>>> Stashed changes
    }
}