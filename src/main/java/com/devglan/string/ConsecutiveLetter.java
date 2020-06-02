package com.devglan.string;

import java.util.Arrays;

public class ConsecutiveLetter {

    public static void main(String[] args){
        String a = "dcfe";
        char[] chars = a.toCharArray();
        Arrays.sort(chars);
        Boolean sorted = true;
        for(int i = 0; i < a.length() -1; i++){
            if(chars[i] - chars[i + 1] != -1){
                sorted = false;
                break;
            }
        }
        System.out.println(sorted);
    }

}
