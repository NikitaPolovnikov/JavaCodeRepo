package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class StreamCollectorsExample {
    private static int limit = 3;
    public static void main(String[] args) {

        List<Order> orders = List.of(
                new Order("Laptop", 1200.0),
                new Order("Smartphone", 800.0),
                new Order("Laptop", 1500.0),
                new Order("Tablet", 500.0),
                new Order("Smartphone", 900.0)
        );

        List<Map.Entry<String, Double>> list = orders.stream().collect(Collectors.groupingBy
                        (Order::getProduct, Collectors.summingDouble(Order::getCost)))
                .entrySet().stream().sorted(Map.Entry.<String, Double>comparingByValue()
                        .reversed()).limit(limit).collect(Collectors.toList());
        System.out.println(list);

    }

}