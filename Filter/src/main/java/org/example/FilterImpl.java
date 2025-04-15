package org.example;

public class FilterImpl implements Filter{
    @Override
    public Object apply(Object o) {
        return Integer.parseInt(o.toString())+5;
    }
}
