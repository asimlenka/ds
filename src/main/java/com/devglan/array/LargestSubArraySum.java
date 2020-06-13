package com.devglan.array;

public class LargestSubArraySum {

    //Kadane's algorithm
    //print the sum of largest sub array
    public static void main(String[] args){
        int[] arr = {-1, 5, -50, 3, -90};
        int length = arr.length;
        int sum = 0;
        int lastSum = 0;
        for(int i =0; i < length; i++){
            sum = sum + arr[i];
            if(sum > lastSum){
                lastSum = sum;
            }else {
                sum  = 0;
            }
        }
        System.out.println(lastSum);
    }
}
