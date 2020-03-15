package com.devglan.tree;

import java.util.Arrays;

class BinarySearch {

    int binarySearch(int arr[], int start, int end, int searchElement) {
        if (end >= start) {
            int mid = start + (end - start)/2;

            if (arr[mid] == searchElement)
                return mid;

            if (arr[mid] > searchElement)
                return binarySearch(arr, start, mid - 1, searchElement);

            return binarySearch(arr, mid+1, end, searchElement);
        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch ob = new BinarySearch();
        int arr[] = {9,5,3,32,13,24};
        Arrays.sort(arr);
        int n = arr.length;
        int x = 13;
        int result = ob.binarySearch(arr,0,n-1 , x);
        if (result == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " +
                    result);
    }
}

