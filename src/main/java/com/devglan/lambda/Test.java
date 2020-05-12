package com.devglan.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test {

    public List<String> filter(List<String> fruits, Predicate<String> p){
        return fruits.stream().filter(f -> p.test(f)).collect(Collectors.toList());
    }

    public List<String> function(List<String> fruits, Function<String, String> p){
        String s1 = "";
        p.apply(s1);
        return fruits.stream().map(f -> p.apply(f)).collect(Collectors.toList());
    }

    public static void main(String[] args){
        OperateInterface multiplication = (x, y) -> x * y;
        int mult = multiplication.operate(6, 7);
        System.out.println(mult);
        OperateInterface addition = (x, y) -> x + y;
        int add = addition.operate(6, 7);
        System.out.println(add);
        new Thread(() -> System.out.println("run() method implementation with a lambda expression.")).start();
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        List<String> list1 = list.subList(0, 2);
        List<String> list2 = list.subList(1, 3);
        System.out.println();
    }
}
