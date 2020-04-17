package com.devglan.practise;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class ClosestToZero {

    public static int find(int[] A){
        Arrays.sort(A);
        int index = Arrays.binarySearch(A, 0);
        if(index < 0){
            int zeroToBeInserted = -(index) - 1;
            return A[zeroToBeInserted];
        }else {
            return A[index];
        }
    }

    public static void operate1(Predicate<Integer> predicate, Function<Integer, Integer> function){
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.stream().map(function).filter(predicate).forEach(System.out :: println);
    }

    public static Function<Integer, Integer> operate(int i){
        return integer -> integer * 10;
    }

    public static void main(String[] args) {
        int[] input1 = {-8, -9, -1, 0, 1, 6, 9, 10, 2};
        System.out.println(ClosestToZero.find(input1));

        int[] input2 = {-8, -9, -1, 1, 6, 9, 10, 2};
        //System.out.println(ClosestToZero.find(input2));

        ClosestToZero.operate1(i -> i > 10, operate(1) );
    }
}

