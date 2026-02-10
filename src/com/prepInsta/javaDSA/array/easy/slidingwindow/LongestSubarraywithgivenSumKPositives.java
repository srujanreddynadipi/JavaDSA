package com.prepInsta.javaDSA.array.easy.slidingwindow;

public class LongestSubarraywithgivenSumKPositives {
    public static void main(String[] args) {

        int[] nums = {10, 5, 2, 7, 1, 9};
        int k = 15 ;
        System.out.println(longestSubArray(nums,k));
    }

    public static int longestSubArray(int[] arr , int k){
        int l = 0; int r = 0 ; int sum = 0 ; int maxlen = 0 ;
        while(r<arr.length){
            sum=sum+arr[r];
            if(sum>k){
                sum = sum - arr[l];
                l = l+1;
            }
            if(sum==k){
                maxlen = Math.max(maxlen,r-l+1);
            }
            r++;
        }
        return maxlen;
    }
}
