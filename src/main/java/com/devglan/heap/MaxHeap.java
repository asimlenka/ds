package com.devglan.heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MaxHeap {

    public static int kthSmallestElement(int k, int[] array){
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int length = array.length;
        for (int i = 0; i < length; i++){
            maxHeap.add(array[i]);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        return maxHeap.peek();
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 8, 9, 4, 7, 6};
        System.out.println(MaxHeap.kthSmallestElement(3, array));
    }
}
