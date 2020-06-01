package com.devglan.practise;

public class LongestPalindrome {

    static String longestPalindrome = null;
    public static String findLongestPalindrome(String s1){
        longestPalindrome = "" + s1.charAt(0);
        for (int i = 0; i < s1.length(); i++){
            expand(s1, i, i);
            expand(s1, i , i + 1);
        }
        return longestPalindrome;
    }

    private static void expand(String s1, int left, int right){
        if (left != right) {
            return;
        }
        while (left >= 0 && right < s1.length() && s1.charAt(left) == s1.charAt(right)){
            left--;
            right++;
        }
        if (longestPalindrome.length() < s1.substring(left + 1, right).length()){
            longestPalindrome = s1.substring(left + 1, right);
        }

    }

    public static void main(String[] args){
        String s1 = "abcmadamcbamadam";
        System.out.print(LongestPalindrome.findLongestPalindrome(s1));
    }
}
