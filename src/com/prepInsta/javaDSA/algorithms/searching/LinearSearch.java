package com.prepInsta.javaDSA.algorithms.searching;

public class LinearSearch {
    public static void search(int[] num , int target){
        for(int i=0 ; i<num.length ; i++){
            if(num[i]==target){
                System.out.println(target + " found at indes " + i);
                return;
            }
        }
        System.out.println("Not found");
    }

    public static void main(String[] args) {
        int[] num = {5,6,8,2,45,78,89};
        int target = 78 ;
        search(num,target);
    }
}

