package com.prepInsta.javaDSA.array.easy.slidingwindow;

public class Leetcode1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        if (arr.length == 0) return 0;
        int l = 0, r = 0;
        double sum = 0;
        int  count = 0 ;
        double maxAvg = Double.NEGATIVE_INFINITY;

        while (r < arr.length) {
            sum += arr[r];
            r++;
            if (r - l > k) {
                sum -= arr[l];
                l++;
            }
            if (r - l == k) {
                maxAvg =  sum / k;
                if(maxAvg >= threshold){
                    count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Leetcode1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold obj = new Leetcode1343_NumberofSubarraysofSizeKandAverageGreaterthanorEqualtoThreshold();
        int[] arr = {2,2,2,2,5,5,5,8};
        int k = 3;
        int threshold = 4;
        int result = obj.numOfSubarrays(arr, k, threshold);
        System.out.println("Number of subarrays of size " + k + " with average >= " + threshold + " is: " + result); // Expected: 3
    }
}