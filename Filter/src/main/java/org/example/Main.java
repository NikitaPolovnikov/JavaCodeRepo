package org.example;

import java.util.ArrayList;

public class Main{

    private static ArrayList<Object> array = new ArrayList<>();
    private static ArrayList<Object> result = new ArrayList<>();


    ArrayList filter (ArrayList arrayList, Filter filter){
        for (Object arrayList1 : arrayList){
            result.add(filter.apply(arrayList1));
        }
        return result;
    }

    public static void main(String[] args) {
        array.add(1);
        array.add(2);
        array.add(3);
        Main test = new Main();
        FilterImpl filterImpl = new FilterImpl();
        test.filter(array, filterImpl);
        System.out.println(result);
    }
}