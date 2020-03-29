package com.devglan.practise;

public class LongestPalindrome {

    public static String findLongestPalindrome(String s1){
        int length = s1.length();
        StringBuilder result = new StringBuilder();
        int mid = length / 2;
        for(int i= 1; i <= (length/2); i++){
            if(s1.charAt(mid - i) == s1.charAt(mid + i)){
                result.append(s1.charAt(mid -i));
            }/*else {
                result = new StringBuilder();
            }*/
        }
        return result.toString() + result.toString();
    }

    public static void main(String[] args){
        String s1 = "bananas";
        System.out.print(LongestPalindrome.findLongestPalindrome(s1));
    }
}
