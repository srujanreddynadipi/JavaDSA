package com.prepInsta.javaDSA.dataStructures.stack;

public class LargestRectangularAreaUnderHistogram {
    static int maxArea(int[] arr , int size ) {
        int res = 0 ;
        for (int i = 0; i < size; i++) {
            int count = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) {
                    count++;
                } else {
                    break;
                }
            }
            for (int j = i + 1; j < size; j++) {
                if (arr[j] > arr[i]) {
                    count++;
                } else {
                    break;
                }
            }
            int temp = count * arr[i];

            res = Math.max(temp , res);
        }
        return  res ;
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 4, 4, 1, 5, 7};
        int n = 7;
        System.out.println("Max Area: " + maxArea(arr, n));
        //Max Area: 12
    }
}
