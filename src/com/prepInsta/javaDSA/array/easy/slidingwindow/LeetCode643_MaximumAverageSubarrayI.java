package com.prepInsta.javaDSA.array.easy.slidingwindow;

public class LeetCode643_MaximumAverageSubarrayI {
    public double findMaxAverage(int[] nums, int k) {

        if (nums.length == 0) return 0;

        int l = 0, r = 0;
        double sum = 0;
        double maxAvg = Double.NEGATIVE_INFINITY;

        while (r < nums.length) {

            // add element
            sum += nums[r];
            r++;

            // if window size becomes greater than k, shrink
            if (r - l > k) {
                sum -= nums[l];
                l++;
            }

            // when window size == k, calculate average
            if (r - l == k) {
                maxAvg = Math.max(maxAvg, sum / k);
            }
        }

        return maxAvg;
    }

    public static void main(String[] args) {
        LeetCode643_MaximumAverageSubarrayI obj = new LeetCode643_MaximumAverageSubarrayI();
        int[] nums = {1, 12, -5, -6, 50, 3};
        int k = 4;
        double result = obj.findMaxAverage(nums, k);
        System.out.println("Maximum average of subarrays of size " + k + " is: " + result); // Expected: 12.75
    }
}
