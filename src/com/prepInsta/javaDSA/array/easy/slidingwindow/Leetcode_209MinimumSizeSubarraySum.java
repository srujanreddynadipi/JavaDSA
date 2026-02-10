package com.prepInsta.javaDSA.array.easy.slidingwindow;

public class Leetcode_209MinimumSizeSubarraySum {
        public int minSubArrayLen(int target, int[] nums) {
            int left  =0 ;
            int sum = 0 ;
            int right =0 ;
            int minlen = Integer.MAX_VALUE;
            while( right < nums.length ){
                if(sum<target){
                    sum = sum + nums[right];
                    right++;
                }
                while(sum>=target){
                    minlen = Math.min(minlen ,right-left);
                    sum = sum - nums[left];
                    left++;
                }
            }
            if (minlen == Integer.MAX_VALUE) return 0;
            return minlen;
        }
    
}
