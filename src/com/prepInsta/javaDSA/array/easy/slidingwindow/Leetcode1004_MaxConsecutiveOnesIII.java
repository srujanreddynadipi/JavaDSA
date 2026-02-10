package com.prepInsta.javaDSA.array.easy.slidingwindow;

public class Leetcode1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int l =0 ;
        int countZero = 0;
        int maxlen = 0 ;
        for(int r =0 ; r<nums.length ; r++){

            if(nums[r]==0){
                countZero++;
            }
            while(countZero  > k ){
                if(nums[l] == 0){
                    countZero--;
                }
                l++;
            }
            maxlen = Math.max(maxlen , r-l+1);
        }
        return maxlen;
    }

    public static void main(String[] args) {
        Leetcode1004_MaxConsecutiveOnesIII obj = new Leetcode1004_MaxConsecutiveOnesIII();
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        int k = 2 ;
        int result = obj.longestOnes(nums,k);
        System.out.println("The longest subarray of 1's after flipping at most " + k + " zeros is: " + result); // Expected: 6
    }
}