package org.example;

import java.util.ArrayList;

public class FilterUtil{

    private static ArrayList<Object> result = new ArrayList<>();
    ArrayList filter (ArrayList arrayList, Filter filter){
        for (Object arrayList1 : arrayList){
            result.add(filter.apply(arrayList1));
        }
        return result;
    }
}
