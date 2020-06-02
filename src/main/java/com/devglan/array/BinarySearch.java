package com.devglan.array;

import java.util.Arrays;

public class BinarySearch {
    public int binarySearchWithRecursion(int [] elements, int start, int last, int searchElement){
        if(elements.length > 0){
            int mid = (start + last)/2;
            if(searchElement == elements[mid]){
                return mid;
            }
            if(searchElement < elements[mid]){
                return binarySearchWithRecursion(elements, start, mid - 1, searchElement);
            }else {
                return binarySearchWithRecursion(elements, mid + 1, last, searchElement);
            }
        }
        return -1;
    }

    public int binarySearchWithoutRecursion(int[] elements, int searchElemenet){
        double maxIteration = Math.round(Math.log(elements.length));
        int iterator = 0;
        int index = -1;
        int start = 0, last = elements.length,mid = 0;
        while(iterator <= maxIteration){
            ++iterator;
            mid = (start + last)/2;
            if(elements[mid] == searchElemenet){
                index = mid;
                break;
            }
            if(searchElemenet < elements[mid]){
                start = 0;
                last = mid - 1;
            }else {
                start = mid + 1;
                last = elements.length;
            }
        }
        return index;
    }

    public static void main(String[] args){
        BinarySearch binarySearch = new BinarySearch();
        int[] arr = {1, 4, 8, 10, 3, 6};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr);
        System.out.println(binarySearch.binarySearchWithRecursion(arr, 0, arr.length - 1, 1));
        System.out.println(binarySearch.binarySearchWithoutRecursion(arr,  1));
    }


}
