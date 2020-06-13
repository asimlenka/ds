package com.devglan.dp.knapsack;

public class SubSetSumAndCount {

    //exponential time complexity. reduce to O(n) with DP and memoization
    public static boolean findSubSetSumEquals(int set[], int n, int sum) {
        if (sum == 0)
            return true;
        if (n == 0 && sum != 0)
            return false;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return findSubSetSumEquals(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return findSubSetSumEquals(set, n - 1, sum - set[n - 1]) || findSubSetSumEquals(set, n - 1, sum);
    }

    public static int findSubSetSumEqualsCount(int set[], int n, int sum) {
        if (sum == 0)
            return 1;
        if (n == 0 && sum != 0)
            return 0;

        // If last element is greater than
        // sum, then ignore it
        if (set[n - 1] > sum)
            return findSubSetSumEqualsCount(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return findSubSetSumEqualsCount(set, n - 1, sum - set[n - 1]) + findSubSetSumEqualsCount(set, n - 1, sum);
    }

    static Boolean[] dp = new Boolean [10];
    public static boolean findSubSetSumEqualsTopDown(int set[], int n, int sum){
       if(n == 0){
           return false;
       }
       if (sum == 0){
           return true;
       }
        if (dp[n] != null){
            return dp[n];
        }
       if (set[n -1] > sum){
           dp[n] = findSubSetSumEqualsTopDown(set, n -1, sum);
           return dp[n];
       }
       dp[n] = findSubSetSumEqualsTopDown(set, n- 1, sum - set[n - 1]) || findSubSetSumEqualsTopDown(set, n - 1, sum);
       return dp[n];
    }

    static boolean[][] dp1 = new boolean[100][100];
    public static boolean findSubSetSumEqualsBottomUp(int set[], int n, int sum){
        for (int i = 0; i <= n; i++)
            dp1[0][i] = true;

        for (int i = 0; i <= n; i++)
            dp1[i][0] = false;

        for (int i = 1; i <= n; i ++){
            for (int j = 1; j <= sum; j++){
                if (set[i - 1] <= j){
                    //enter the current value then go up and find the existing value for remianing weight
                    //i = 3 and j = 4  copy value from above box and rewaming weight is 1 hence go up and pick j for 1(3 steps back from 4 th index)
                    dp1[i][j] = dp1[i - 1][j - 1] || dp1[i -1][j - set[i - 1]] ;
                }else {
                    //copy value from top
                    dp1[i][j] = dp1[i - 1][j];
                }
            }
        }
        printSubSet(set, sum);
        return dp1[n][sum];
    }

    //not correct. revisit
    private static void printSubSet(int[] set, int sum) {

    }

    /* Driver program to test above function */
    public static void main(String args[])
    {
        int set[] = { 3, 34, 4, 12, 5, 2 };
        int sum = 9;
        int n = set.length;
        if (findSubSetSumEquals(set, n, sum) == true)
            System.out.println("Found a subset"
                    + " with given sum");
        else
            System.out.println("No subset with"
                    + " given sum");
        System.out.println(findSubSetSumEqualsBottomUp(set, n, sum));

        System.out.println(findSubSetSumEqualsCount(set, n, sum));
    }
}
