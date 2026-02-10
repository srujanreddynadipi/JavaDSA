package com.prepInsta.javaDSA.array.easy;
import java.util.Arrays;

/*
 Problem:
 Given an array containing numbers from 0 to n with one number missing,
 find the missing number.

 Example:
 Input: [3,0,1]
 Output: 2
*/

public class LeetCode268_MissingNumber {

    public static int missingNumber(int[] nums) {

        // Step 1: Sort the array
        Arrays.sort(nums);

        int n = nums.length;

        // Step 2: Check if index matches value
        for (int i = 0; i < n; i++) {
            if (nums[i] != i) {
                return i;   // first mismatch is the missing number
            }
        }

        // Step 3: If all matched, missing number is n
        return n;
    }

    // Testing
    public static void main(String[] args) {
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums)); // Output: 2
    }
}
