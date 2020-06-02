package com.devglan.string;

import java.util.HashMap;
import java.util.Map;

public class PalindromicAnagram {

    public static void main(String[] args) {
        //if a palindrome can be formed
        String string = "racecar";

        Map<Character, Integer> map = new HashMap<>();

        int length = string.length();
        for (int i = 0; i < length; i++){
            char letter = string.charAt(i);
            if (map.get(letter) == null){
                map.put(letter, 1);
            }else {
                map.put(letter, map.get(letter) + 1);
            }
        }
        final int[] oddCharCount = {0};
        map.values().forEach(val -> {
            if(val %2 != 0){
                oddCharCount[0] = oddCharCount[0] + 1;
            }
        });
        if (oddCharCount[0] > 1){
            System.out.println(false);
        }else{
            System.out.println(true);
        }
    }
}
