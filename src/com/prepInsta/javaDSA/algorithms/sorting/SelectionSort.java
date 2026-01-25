package com.prepInsta.javaDSA.algorithms.sorting;

public class SelectionSort {
    public static void sort(int[] arr ){
        int n = arr.length ;
        for(int i=0 ; i< n ; i++){
            int minIndex = i;
            for(int j = i+1 ; j< n ;j++){
                if(arr[minIndex] > arr[j]){
                    minIndex = j ;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex]=arr[i];
            arr[i] = temp;
        }
        System.out.println("sorted array is :");
        for(int num : arr){
            System.out.print(num + " ");
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,2,6,8,2,1,0};
        System.out.println("unsorted array is :");
        for(int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();
        sort(arr);

        // unsorted array is :
        // 5 2 6 8 2 1 0
        // sorted array is :
        // 0 1 2 2 5 6 8
    }
}
