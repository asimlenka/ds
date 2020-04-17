package com.devglan.lambda;

import java.util.Arrays;
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
        Test test = new Test();
        List<String> fruits = test.function(Arrays.asList("apple", "orange"), (s1) -> s1.concat("fff"));
        System.out.println(fruits.get(0));
    }
}
