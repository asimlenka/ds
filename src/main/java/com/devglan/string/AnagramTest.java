package com.devglan.string;

import java.util.Arrays;

public class AnagramTest {

    public static boolean isAnagram(String word, String anagram) {
        boolean isAnagram = true;
        if (word.length() != anagram.length()){
            isAnagram = false;
        }else {
            int[] array = new int[128];
            Arrays.fill(array, 0);
            for (int i = 0; i < word.length(); i++) {
                array[word.charAt(i)] = array[word.charAt(i)] + 1;
            }
            for (int i = 0; i < anagram.length(); i++) {
                array[anagram.charAt(i)] = array[anagram.charAt(i)] - 1;
            }
            for (int i = 0; i < 128; i++) {
                if (array[i] != 0) {
                    isAnagram = false;
                    break;
                }
            }
        }
        return isAnagram;

    }

    public static void main(String[] args) {
        String input1= "cat";
        String input2 = "act";
        System.out.println(isAnagram(input1, input2));
    }
}
