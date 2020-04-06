package com.devglan.practise;

import java.util.*;


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

    public static void main(String[] args) {
        int[] input1 = {-8, -9, -1, 0, 1, 6, 9, 10, 2};
        System.out.println(ClosestToZero.find(input1));

        int[] input2 = {-8, -9, -1, 1, 6, 9, 10, 2};
        System.out.println(ClosestToZero.find(input2));
    }
}

