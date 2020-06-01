package com.devglan.practise;

import java.util.Arrays;

public class Fibonacci {

    //with plain recursion the time complexity would be O(2^n). with DP its linear(top down approach with tabular storage)

    static int[] array = new int[6];
    static {
        Arrays.fill(array, 0);
    }

    public static int findFibonnaci(int num){
        if (num <= 1){
            return 1;
        }
        if (array[num] == 0) {
            return findFibonnaci(num - 1) + findFibonnaci(num - 2);
        }else {
            return array[num];
        }
    }

    public static void main(String[] args) {
        System.out.println(Fibonacci.findFibonnaci(5));
    }
}
