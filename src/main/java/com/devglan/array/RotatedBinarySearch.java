package com.devglan.array;

public class RotatedBinarySearch {

    //5, 6, 7, 8, 9, 10, 1, 2, 3
    public static int rotatedArraySearch(int[] array, int left, int right, int num) {
        if (array == null || array.length == 0) {
            return -1;
        }
        //the sorted and rotated array is divided into two sorted array. Hence first find the pivot element for these two array.
        //It's 1 in our case. To find this use binary search
        while (left < right){
            int mid = (left + right)/ 2;
            if (array[mid] > array[right]){
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        right = array.length - 1;

        if (num >= array[left] && num <= array[right]){
           right = array.length - 1;
        }else {
            left = 0;
            right = left;
        }
        while (left <= right){
            int mid = (left + right)/2;
            if (array[mid] == num){
                return mid;
            }
            if (num < array[mid]){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        int[] array = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        System.out.println(RotatedBinarySearch.rotatedArraySearch(array, 0, array.length - 1, 2));
    }
}
