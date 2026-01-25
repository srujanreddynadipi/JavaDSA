package com.prepInsta.javaDSA.dataStructures.hashing;

import java.util.Scanner;

public class NumberHashing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int size = sc.nextInt();
        System.out.println("Enter elements of array:");
        int[] arr = new int[size];
        for(int i=0 ; i<size ; i++){
            arr[i] = sc.nextInt();
        }

        int[] hash = new int[size+1];
        for(int i=0 ; i<size ; i++){
            hash[arr[i]]++;
        }

        System.out.println("Enter number of queries:");
        int userinputsize = sc.nextInt();
        System.out.println("Enter queries:");
        for(int i=0 ; i<userinputsize ; i++){
            int query = sc.nextInt();
            System.out.println(hash[query]);
        }
    }
    /*Enter size of array:
            5
    Enter elements of array:
            1 2 3 2 3
    Enter number of queries:
            5
    Enter queries:
            1 2 3 4 5
            1
            2
            2
            0
            0*/

    //We may encounter a problem where the maximum array element may be very large like 109. In that case, theoretically, we should declare an array of size 109+1. But we cannot do so. The maximum size of an array can be the following:
}
