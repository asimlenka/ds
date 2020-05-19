package com.devglan.array;

import java.util.Stack;

public class Palindrome {

    public static void main(String[] args) {
        String s = "aabaa";
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i <= s.length()/2; i++){
            stack.push(s.charAt(i));
        }
        boolean palindrome = true;
        for(int i = s.length()/2; i < s.length(); i++){
            if (stack.pop() != s.charAt(i)){
                palindrome = false;
            }
        }
        System.out.println(palindrome);
    }
}
