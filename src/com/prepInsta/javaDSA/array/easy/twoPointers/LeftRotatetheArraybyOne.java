package com.prepInsta.javaDSA.array.easy.twoPointers;

public class LeftRotatetheArraybyOne {
    public static void rotate(int[] arr){
        int n = arr.length;
        int temp =arr[0];
        for(int i =1 ; i< n ; i++){
            arr[i-1] = arr[i];
        }
        arr[n-1]=temp;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
