package com.prepInsta.javaDSA.array.easy;

public class FindSecondSmallestandSecondLargestElementInAnArray {


        // Method to find the second smallest and second largest elements in the array
        public static void getElements(int[] arr, int n) {

            // Edge case: when the array has less than 2 elements
            if (n == 0 || n == 1) {
                System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
                return;
            }

            // Initialize variables to track the smallest, second smallest, largest, and second largest elements
            int small = Integer.MAX_VALUE, second_small = Integer.MAX_VALUE;
            int large = Integer.MIN_VALUE, second_large = Integer.MIN_VALUE;

            // Find the smallest and largest elements in the array
            for (int i = 0; i < n; i++) {
                small = Math.min(small, arr[i]);  // Update the smallest element
                large = Math.max(large, arr[i]);  // Update the largest element
            }

            // Find the second smallest and second largest elements
            for (int i = 0; i < n; i++) {
                if (arr[i] < second_small && arr[i] != small) {
                    second_small = arr[i];  // Update second smallest if a smaller element is found
                }
                if (arr[i] > second_large && arr[i] != large) {
                    second_large = arr[i];  // Update second largest if a larger element is found
                }
            }

            // Output the second smallest and second largest elements
            System.out.println("Second smallest is " + second_small);
            System.out.println("Second largest is " + second_large);
        }

    public static void main(String[] args) {

        // Driver code
        int n = 6;
        int[] arr = {1, 2, 4, 6, 7, 5};  // Array of elements

        // Call the function to find and print the second smallest and second largest elements
        getElements(arr, n);
    }
}


