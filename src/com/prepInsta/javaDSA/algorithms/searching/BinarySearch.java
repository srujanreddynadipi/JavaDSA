package com.prepInsta.javaDSA.algorithms.searching;

public class BinarySearch {
    public static int search(int[] num , int target){
       int left = 0 ;
       int right = num.length-1;
       while(left<=right){
           int mid = (left+right)/2;
           if(target < num[mid])
               right = mid -1 ;
          else if (target > num[mid])
               left = mid + 1 ;
           else return mid;
       }
       return -1;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,4,5,6,17,8,9};
        int target = 1 ;
        System.out.println(search(num ,target));
    }
}
