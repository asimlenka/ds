package com.devglan.array;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array {

    //try sub set problem using DP
    public static void findSumEquals(int[] arr, int sumEquals){
        int length = arr.length;
        Set<Pair> set = new HashSet<>();
        for (int i = 0; i < length; i++){
            for (int j = i + 1; j < length ; j++) {
                if (arr[i] + arr[j] == 5) {
                    Pair pair = new Pair(arr[i], arr[j]);
                    set.add(pair);
                }
            }
        }
        System.out.println(set);
    }

    public static void getPairsCount(int[] arr, int sum)
    {

        int count = 0;// Initialize result

        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if ((arr[i] + arr[j]) == sum)
                    count++;

        System.out.printf("Count of pairs is %d",count);
    }

    public static void main(String[] args){
        int[] array = {2, 3, 4, 2, 3, 4, 1, 5};

       Array.findSumEquals(array, 5);
       Array.getPairsCount(array, 5);
    }
}
