package com.devglan.heap;

import java.util.PriorityQueue;

public class MinHeap {

    public static int kthLargestElement(int k, int[] array){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int size = array.length;
        for (int i = 0; i < size; i++){
            minHeap.add(array[i]);
            if (minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] array = {7, 10, 4, 3, 20, 15, 2};
        System.out.println(MinHeap.kthLargestElement(3, array));
    }
}
