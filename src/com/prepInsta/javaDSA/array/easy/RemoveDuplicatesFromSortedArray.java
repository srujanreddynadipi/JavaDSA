package com.prepInsta.javaDSA.array.easy;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        if (nums.length==0) return 0 ;
        int i = 0 ;
        for(int j =1 ;j < nums.length ; j++){
            if(nums[j]!=nums[i]){
                i++;
                nums[i]=nums[j];
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        int[] arr = {0,0,1,1,1,2,2,3,3,4};
        RemoveDuplicatesFromSortedArray obj = new RemoveDuplicatesFromSortedArray();
        int length = obj.removeDuplicates(arr);
        System.out.println("Length after removing duplicates: " + length);

    }
}
