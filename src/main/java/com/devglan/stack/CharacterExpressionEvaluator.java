package com.devglan.stack;

import java.util.*;

public class CharacterExpressionEvaluator {
    public static class A{
        Map<String, Integer> map = new HashMap<>();

        public void do1(){
            map.put("dd", 44);
            double d = 0.0;
            List<Double> list = new ArrayList<>();
           d =  list.stream().reduce(Double :: sum).get();
        }
    }

    //a + b + (-c -d) -e  a+b-c-d-e

    public static String evaluate(String expression) {
        int[] a = {3, 2, 4};
        Arrays.sort(a);
        int index = Arrays.binarySearch(a, 6);
        System.out.println(index);
        return null;
    }
    public static void main(String[] args){
        System.out.println(evaluate("a + b + (-c -d) -e  a+b-c-d-e"));
    }
}
