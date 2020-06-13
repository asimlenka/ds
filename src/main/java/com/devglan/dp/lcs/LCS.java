package com.devglan.dp.lcs;

import java.util.Arrays;
//lowest common subsequence
public class LCS {

    public static int lcs(String s1, String s2, int l1, int l2){
        if (l1 == 0 || l2 == 0){
            return 0;
        }
        if (s1.charAt(l1 -1) == s2.charAt(l2 -1)){
            return 1 + lcs(s1, s2, l1 -1, l2 - 1);
        }else {
            return Math.max(lcs(s1, s2, l1 - 1, l2), lcs(s1, s2, l1, l2 -1));
        }
        //return lcs(s1, s2, l1 -1, l2 -1);
    }

    static int[][] dp;

    public static int lcsMemoization(String s1, String s2, int l1, int l2){
        if (l1 == 0 || l2 == 0){
            return 0;
        }
        if (dp[l1][l2] != -1){
            return dp[l1][l2];
        }
        if (s1.charAt(l1 -1) == s2.charAt(l2 -1)){
            dp[l1][l2] =  1 + lcs(s1, s2, l1 -1, l2 - 1);
        }else {
            dp[l1][l2] = Math.max(lcs(s1, s2, l1 - 1, l2), lcs(s1, s2, l1, l2 -1));
        }
        return dp[l1][l2];
        //return lcs(s1, s2, l1 -1, l2 -1);
    }

    public static void lcsBottomUp(String s1, String s2, int l1, int l2){
        int t[][] = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l2; i++){
            t[0][i] = 0;
        }
        for (int j = 0; j < l1; j++){
            t[j][0] = 0;
        }
        for (int i = 1; i <= s1.length(); i++){
            for (int j = 1; j <= s2.length(); j++){
                if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                    t[i][j] = t[i - 1] [j -1] + 1;
                }else {
                    t[i][j] = Math.max(t[i -1] [j], t[i][j -1]);
                }
            }
        }
        //print
        char[] lcs = new char[50];
        int i = l1;
        int j = l2;
        while (i > 0 && j > 0){
            if (s1.charAt(i - 1) == s2.charAt(j - 1)){
                lcs[i - 1] = s1.charAt(i - 1);
                i--;
                j--;
            }
            else if (t[i -1][j] > t[i][j -1]){
                i--;
            }else {
                j--;
            }
        }
        for (int k = 0; k< lcs.length; k++){
            char temp = lcs[k];
            if (temp != 0)
                System.out.println(lcs[k]);
        }
        //return t[s1.length()][s2.length()];
    }

    public static void main(String[] args) {
        String s1 = "abcdef";
        String s2 = "bcdf";

        System.out.println(LCS.lcs(s1, s2, s1.length(), s2.length()));

        dp = new int[7][5];
        for (int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        System.out.println(LCS.lcsMemoization(s1, s2, s1.length(), s2.length()));
        LCS.lcsBottomUp(s1, s2, s1.length(), s2.length());
        //LCS.printLcs(s1, s2, s1.length(), s2.length());
    }
}
