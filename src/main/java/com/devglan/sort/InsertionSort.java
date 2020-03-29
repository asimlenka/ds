package com.devglan.sort;

import java.util.Arrays;

public class InsertionSort {

    public void insertionSort(int[] inputArray){
        System.out.println("Input array " + Arrays.toString(inputArray));
        for(int i = 0; i < inputArray.length; i++ ){
            int temp = inputArray[i];
            int j = i;
            while(j > 0 && inputArray[j -1] > temp){
                inputArray[j] = inputArray[j - 1];
                j = j - 1;
            }
            inputArray[j] = temp;
        }
        System.out.println("Sorted array " + Arrays.toString(inputArray));
    }

    public static void main(String[] args){
        InsertionSort insertionSort = new InsertionSort();
        int[] array = {8, 5, 3, 9, 1, 4, 12};
        insertionSort.insertionSort(array);
    }
}
