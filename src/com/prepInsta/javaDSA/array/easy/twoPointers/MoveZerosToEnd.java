package com.prepInsta.javaDSA.array.easy.twoPointers;

public class MoveZerosToEnd {
    public void moveZeroes(int[] nums) {
        int i =0 ;
        for(int j= 0 ; j<nums.length ; j++){
            if(nums[j]!=0){
                nums[i]=nums[j];
                i++;
            }
        }
        for(int j=i ; j<nums.length ;j++){
            nums[j] = 0 ;
        }
    }
    public static void main(String[] args) {
        MoveZerosToEnd obj = new MoveZerosToEnd();
        int[] arr = {0,1,0,3,12};
        obj.moveZeroes(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
