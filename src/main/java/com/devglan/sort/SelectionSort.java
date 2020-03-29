package com.devglan.sort;

import java.util.Arrays;

public class SelectionSort {

    public void selectionSort(int[] inputArray){
        System.out.println("Input array " + Arrays.toString(inputArray));
        for(int i = 0; i < inputArray.length - 1; i++){
            int min = i;
            for(int j = i + 1; j < inputArray.length; j++){
                if(inputArray[j] < inputArray[min]){
                    min = j;
                }
                int temp = inputArray[min];
                inputArray[min] = inputArray[i];
                inputArray[i] = temp;
            }
        }
        System.out.println("Sorted array " + Arrays.toString(inputArray));
    }

    public static void main(String[] args){
        SelectionSort bubbleSort = new SelectionSort();
        int[] array = {8, 5, 3, 9, 1, 4, 12};
        bubbleSort.selectionSort(array);
    }
}
