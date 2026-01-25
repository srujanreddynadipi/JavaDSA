package com.prepInsta.javaDSA.array.easy;

public class RotateArrayByN {
    public static void rotate(int[] arr, int k) {
        int n = arr.length;
        k = k % n;

        while (k-- > 0) {
            int temp = arr[n - 1];
            for (int i = n - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = temp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        rotate(arr, 3);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
