package com.devglan.dp.knapsack;

public class EqualSubSetSumPartition {

    public static boolean isEqualSumPartition(int[] arr, int length){
        int sum = 0 ;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        if (sum % 2 != 0){
            return false;
        }else {
            return isSubSetEqualSum(arr, length, sum/2);
        }
    }

    private static boolean isSubSetEqualSum(int[] arr, int length, int sum) {
        if (length == 0){
            return false;
        }
        if (sum == 0){
            return true;
        }
        if (arr[length - 1] > sum){
            return isSubSetEqualSum(arr, length - 1, sum);
        }
        boolean included = isSubSetEqualSum(arr,length - 1, sum - arr[length - 1]);
        boolean notIncluded = isSubSetEqualSum(arr, length - 1, sum);
        return included || notIncluded;
    }

    public static void main(String[] args) {
        int set[] = { 1, 5, 11, 5 };
        System.out.println(EqualSubSetSumPartition.isEqualSumPartition(set, set.length));
    }
}
