package com.devglan.array;

import java.util.*;
//imp
public class Array {

    //solution to find the number of subarray whose sum equals given sum in O(n)
    //space complexity of O(n)-
    public static int findSumEquals(int[] arr, int sumEquals){
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int count = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
            Integer value = map.get(sum);
            if (value == null){
                map.put(sum, 1);
            }else {
                map.put(sum, value + 1);
            }
            int sum1 = sum - sumEquals;
            Integer value1 = map.get(sum1);
            //if hashMap already has the value, means we already
            // have subarray with the sum - so increase the count
            if (value1 != null){
                count = count +1;
            }
        }
        return count;
    }

    public static void printSubArrayWithSumEquals(int[] arr, int sumEquals){
        int currentSum = 0;
        int endIndex = 0;
        int startIndex = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++){
            currentSum = currentSum + arr[i];
            //check whether cur_sum - sum = 0, if 0 it means
            //the sub array is starting from index 0- so stop
            if (currentSum - sumEquals == 0){
                startIndex = 0;
                endIndex = i;
                break;
            }
            Integer value = map.get(currentSum - sumEquals);
            //if hashMap already has the value, means we already
            // have subarray with the sum - so stop
            if (value != null){
                startIndex = value + 1;
                endIndex = i;
                break;
            }
            map.put(currentSum, i);
        }
        for (int i = startIndex; i <= endIndex; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args){
        //int[] array = {2, 3, 4, 2, 3, 4, 1, 5};
        int[] array = {4, 2, 3, 4, 1, 5};
        System.out.println("Count = " + Array.findSumEquals(array, 5));
        Array.printSubArrayWithSumEquals(array, 5);
    }
}
