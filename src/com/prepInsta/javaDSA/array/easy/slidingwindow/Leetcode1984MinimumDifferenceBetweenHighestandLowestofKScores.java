package com.prepInsta.javaDSA.array.easy.slidingwindow;

import java.util.Arrays;

public class Leetcode1984MinimumDifferenceBetweenHighestandLowestofKScores {
    public static int minimumDifference(int[] nums, int k) {
        if(nums.length<=1){
            return 0;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        for(int i =0 ; i+k-1<nums.length ; i++){
            int diff = nums[i+k-1] - nums[i];
            min = Math.min(min , diff);
        }
        return min ;
    }

    public static void main(String[] args) {

        int[] nums = {90, 101, 78, 65, 87, 99};
        int k = 3 ;
        System.out.println(minimumDifference(nums,k));
    }
}
