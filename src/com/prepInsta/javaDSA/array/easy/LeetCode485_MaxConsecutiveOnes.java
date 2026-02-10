package com.prepInsta.javaDSA.array.easy;

/*
 Problem:
 Given a binary array, return the maximum number of consecutive 1s.

 Example:
 Input: [1,1,0,1,1,1]
 Output: 3
*/

public class LeetCode485_MaxConsecutiveOnes {

    public static int findMaxConsecutiveOnes(int[] nums) {

        int currentCount = 0;  // count of current 1s streak
        int maxCount = 0;      // maximum streak found

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                currentCount++; // extend streak
                maxCount = Math.max(maxCount, currentCount);
            } else {
                currentCount = 0; // reset when 0 appears
            }
        }

        return maxCount;
    }

    // Testing
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums)); // Output: 3
    }
}
