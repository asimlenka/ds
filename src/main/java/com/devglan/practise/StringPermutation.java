package com.devglan.practise;

import java.util.HashSet;
import java.util.Set;

public class StringPermutation {

    static Set<String> set = new HashSet<>();

    public static void permutation(String input){
        permutation("", input);
    }

    private static void permutation(String perm, String input){
        if (input.length() == 0){
            System.out.println(perm);
        }else {
            for (int i = 0; i < input.length(); i++) {
                //for ABC
                //for i = 0 -> perm a,  "" + bc
                //for i = 1 -> perm = b,  a + c
                //for i = 2 -> perm = c,  ab + ""
                //then it will go into recursion
                permutation(perm + input.charAt(i), input.substring(0, i) + input.substring(i + 1));
            }
        }
    }

    public static void main(String[] args) {
        StringPermutation.permutation("abc");
        //set.add("abc");
        set.forEach((a) -> System.out.println(a));
    }
}
