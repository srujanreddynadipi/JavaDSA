package com.prepInsta.javaDSA.algorithms.sorting;

public class BubbleSort {
    static void bubble(int[] arr){
        boolean swapped ;
        for(int i =0 ; i < arr.length ; i++){
            swapped = false ;
            for(int j = 1 ; j<arr.length-i-1 ; j++){
                if(arr[j-1]>arr[j]){
                    int temp = arr[j-1];
                    arr[j-1]=arr[j];
                    arr[j]= temp;
                    swapped = true ;
                }
            }
            if(!swapped){
                break;
            }
        }
        System.out.println("sorted array is :");
        for(int num : arr){
            System.out.print(num+" ");
        }
    }

    public static void main(String[] args) {
        int [] arr = {5,2,6,8,2,1,0};
        System.out.println("unsorted array is :");
        for(int num : arr){
            System.out.print(num+" ");
        }
        System.out.println();
        bubble(arr);
    }
}
