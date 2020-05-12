package com.devglan.array;

import java.util.Arrays;

public class ArrayReverse {

    public static int[] reverse(int[] array){
        int length = array.length;
        for (int i = 0; i < length/2; i++){
            int start = array[i];
            int end = array[length - 1 - i];
            array[length - 1 - i] = start;
            array[i] = end;
        }
        return array;
    }

    public static void main(String[] args){
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int[] reversedArray = ArrayReverse.reverse(array);
        System.out.println(Arrays.toString(reversedArray));
    }
}
