package com.devglan.array;

import java.util.Arrays;

public class Anagram {

    public static void main(String[] args) {
        int[] array1 = new int[128];
        int[] array2 = new int[128];
        Arrays.fill(array1, 0);
        Arrays.fill(array2, 0);
        String word1 = "abcdcnh";
        String word2 = "nhabccde";
        int word1Length = word1.length();
        int word2Length = word2.length();
        if (word1Length != word2Length){
            System.out.println(false);
            System.exit(0);
        }
        for (int i = 0; i < word1Length; i++){
            array1[word1.charAt(i)] = array1[word1.charAt(i)] + 1;
        }
        for (int i = 0; i < word2Length; i++){
            array2[word2.charAt(i)] = array2[word2.charAt(i)] + 1;
        }
        boolean anagram = true;
        for (int i = 0; i < array1.length; i++){
            if (array1[i] != array2[i]) {
                anagram = false;
                break;
            }
        }
        System.out.print(anagram);
    }
}
