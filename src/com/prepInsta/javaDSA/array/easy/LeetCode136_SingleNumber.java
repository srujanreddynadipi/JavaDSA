package com.prepInsta.javaDSA.array.easy;
import java.util.Arrays;

/*
 Problem:
 Every element appears twice except one.
 Find the element that appears only once.

 Example:
 Input: [2,2,1]
 Output: 1
*/

public class LeetCode136_SingleNumber {

    public static int singleNumber(int[] nums) {

        // Step 1: Sort array
        Arrays.sort(nums);

        // Step 2: Check pairs
        for (int i = 1; i < nums.length; i += 2) {
            if (nums[i] != nums[i - 1]) {
                return nums[i - 1];
            }
        }

        // Step 3: Last element is the single number
        return nums[nums.length - 1];
    }

    // Testing
    public static void main(String[] args) {
        int[] nums = {2, 2, 1};
        System.out.println(singleNumber(nums)); // Output: 1
    }
}
