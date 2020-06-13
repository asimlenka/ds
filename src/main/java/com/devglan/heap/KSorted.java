package com.devglan.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KSorted {

    public static void sortKSortedArray(int[] array, int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int length = array.length;
        for (int i = 0; i < k; i++){
            minHeap.add(array[i]);
        }
        int index = 0;
        for (int i = k; i < length; i++){
            minHeap.add(array[i]);
            array[index] = minHeap.poll();
            ++index;
        }

        while(minHeap.iterator().hasNext()){
            array[index] = minHeap.poll();
            ++index;
        }
    }

    public static void main(String[] args) {
        int[] arr = {10, 9, 8, 7, 5, 70, 60, 50};
        System.out.println(Arrays.toString(arr));
        KSorted.sortKSortedArray(arr, 4);
        System.out.println(Arrays.toString(arr));
    }
}
