package com.devglan.dp.knapsack;

import java.util.Arrays;

public class Knapsack {

    public static int knapsack(int[] weight, int[] profit, int W, int n){
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
            return knapsack(weight, profit, W, n -1);
        }
        //check what is the profit if n-1th item weight plus remaining weight
        int profitAdded = profit[n - 1] + knapsack(weight, profit, W - weight[n - 1] ,n -1);
        //check what is the profit if n-1th item weight not added but adding remaining weight
        int profitNotAdded = knapsack(weight, profit, W, n-1);
        //now find the maximum profit with either adding n+1 th item or not adding n+1th item
        return Math.max(profitAdded, profitNotAdded);
    }

    static int[][] dp = new int[100][100];

    public static int knapsackDpTopDown(int[] weight, int[] value, int W, int n){
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

    static int[][] t = new int[100][100];
    public static int knapsackDpBottomUp(int[] weight, int[] value, int W, int n){
        for (int i = 1; i < n+1; i++){
            for (int j = 1; j < W + 1; j++){
                if (weight[i - 1] <= j){
                    //t[i - 1][j - weight[i - 1]  - (previous row max profit for this weight  + max profit for reamainig weight()) || (previous row max profit for this weight )
                    t[i - 1][j - 1] = Math.max(value[i - 1] + t[i - 1][j - weight[i - 1]], t[i - 1][j - 1]);
                }else {
                    //can't accomodate this weight and hence same previous value will be copied
                    t[i][j] = t[i -1][j];
                }
            }
        }
        return t[n -1 ][W-1];
    }

    public static void main(String[] args) {

        int[] weight = {2, 4, 6};
        int[] profit = {10, 20, 30};
        System.out.println(Knapsack.knapsack(weight, profit, 6, 3));
        for (int[] row: dp) {
            Arrays.fill(row, -1);
        }
        System.out.println(Knapsack.knapsackDpTopDown(weight, profit, 6, 3));
        for (int[] row: t) {
            Arrays.fill(row, 0);
        }
        System.out.println(Knapsack.knapsackDpBottomUp(weight, profit, 6, 3));
    }
}
