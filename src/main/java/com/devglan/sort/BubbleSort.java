package com.devglan.sort;

import java.util.Arrays;

public class BubbleSort {

    public void bubbleSort(int[] input){
        //int n = input.length;
        System.out.println("Input array " + Arrays.toString(input));
        for(int i = input.length - 1; i >= 0; i--){
            for(int j = 0; j <= i - 1; j++){
                if(input[j] > input[j + 1]){
                    int temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                }
            }
        }
        System.out.println("Output Array: " + Arrays.toString(input));
    }

    public static void main(String[] args){
        BubbleSort bubbleSort = new BubbleSort();
        int[] array = {8, 5, 3, 9, 1, 4, 12};
        bubbleSort.bubbleSort(array);
    }
}
