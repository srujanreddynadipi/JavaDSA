package com.prepInsta.javaDSA.algorithms.sorting;

public class InsertionSort {
    public static void insertion(int[] arr ){
        for(int i = 0 ; i<arr.length - 1 ; i++){
            for(int j = i+1 ; j>0 ; j--){
                if(arr[j] < arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
        System.out.println("sorted array :");
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
        insertion(arr);
    }
}
