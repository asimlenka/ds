package com.devglan.sort;

import java.util.Arrays;

public class MergeSort {

    public void mergeSort(int input[], int left, int right){
        if (left < right) {
            int mid = (left + right)/2;
            mergeSort(input, left, mid);
            mergeSort(input , mid + 1, right);
            merge(input, left, mid, right);
        }
    }

    public void merge(int arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i=0; i<n1; ++i)
            L[i] = arr[l + i];
        for (int j=0; j<n2; ++j)
            R[j] = arr[m + 1+ j];


        /* Merge the temp arrays */

        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args){
        MergeSort mergeSort = new MergeSort();
        int[] array = {8, 5, 3, 9, 1, 4, 12};
        System.out.println("Input array " + Arrays.toString(array));
        mergeSort.mergeSort(array, 0, array.length - 1 );
        System.out.println("Sorted array " + Arrays.toString(array));
    }
}
