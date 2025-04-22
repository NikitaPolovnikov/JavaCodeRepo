package org.example;

public class FilterCountingIntImpl implements Filter{
    @Override
    public Object apply(Object o) {
        return Integer.parseInt(o.toString())+5;
    }
}
