package com.devglan.dp;

public class SubSet {

    static int[] result = new int[10];
    //exponential time complexity. reduce to O(n) with DP and memoization
    public static boolean findSubSetSumEquals(int set[], int n, int sum){
        if (sum == 0){
            result[n] = 1;
            return true;
        }
        if (n == 0){
            return false;
        }
        if (set[n-1] > sum){
            return findSubSetSumEquals(set, n -1, sum);
        }
        return findSubSetSumEquals(set, n -1, sum) || findSubSetSumEquals(set, n - 1, sum - set[n - 1]);
    }


    /* Driver program to test above function */
    public static void main(String args[])
    {
        int set[] = { 1, 2, 3, 4 };
        int sum = 3;
        int n = set.length;
        if (findSubSetSumEquals(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
    }
}
