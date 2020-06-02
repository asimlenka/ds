package com.devglan.dp;

import java.util.Arrays;

public class Knapsack {

    public static int knapsack(int[] weight, int[] value, int W, int n){
        if (W == 0){
            return 0;
        }
        if (n == 0){
            return 0;
        }
        //3 choices - 1. if current weight is greater then Knapsack weight go for next weight in the array
        // 2. either select or don't select=> Choose the maximum (value added or not added)
        //if not selected W will be same but the n will be (n - 1)
        //next weight will be n-1, for an array of length 5, current index is (n -1)=> (5 -1) => 4  and next will be (n - 1) => (4 -1 )i.e. 3
        if (weight[n - 1] > W){
            return knapsack(weight, value, W, n -1);
        }
        int valueAdded = value[n - 1] + knapsack(weight, value, W - weight[n - 1] ,n -1);
        int valueNotAdded = knapsack(weight, value, W, n-1);
        return Math.max(valueAdded, valueNotAdded);
    }

    static int[][] dp = new int[100][100];

    public static int knapsackDp(int[] weight, int[] value, int W, int n){
        if (W == 0){
            return 0;
        }
        if (n == 0){
            return 0;
        }
        //3 choices - 1. if current weight is greater then Knapsack weight go for next weight in the array
        // 2. either select or don't select=> Choose the maximum (value added or not added)
        //if not selected W will be same but the n will be (n - 1)
        //next weight will be n-1, for an array of length 5, current index is (n -1)=> (5 -1) => 4  and next will be (n - 1) => (4 -1 )i.e. 3
        if (dp[W][n] != -1){
            return dp[W][n];
        }
        if (weight[n - 1] > W){
            dp[W][n] =  knapsack(weight, value, W, n -1);
            return dp[W][n];
        }
        int valueAdded = value[n - 1] + knapsack(weight, value, W - weight[n - 1] ,n -1);
        int valueNotAdded = knapsack(weight, value, W, n-1);
        dp[W][n] =  Math.max(valueAdded, valueNotAdded);
        return dp[W][n];
    }

    public static void main(String[] args) {

        int[] weight = {2, 4, 6};
        int[] value = {10, 20, 30};
        System.out.println(Knapsack.knapsack(weight, value, 6, 3));
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(Knapsack.knapsackDp(weight, value, 6, 3));
    }
}
