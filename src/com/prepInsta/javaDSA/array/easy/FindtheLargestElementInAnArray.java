package com.prepInsta.javaDSA.array.easy;

public class FindtheLargestElementInAnArray {
    public static int findLargest(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 2, 8};
        System.out.println("The largest element in the array is: " + findLargest(arr)); // 8
    }
}
