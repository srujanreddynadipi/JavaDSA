package com.prepInsta.javaDSA.dataStructures.hashing;

import java.util.Scanner;
import java.util.HashMap;

public class HashMap1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter elements of array:");
        for(int i=0 ; i< n ; i++){
            arr[i] = sc.nextInt();
        }

        HashMap<Integer,Integer> mp = new HashMap<>();
        for(int i =0 ; i<n ;i++){
            int key = arr[i];
            int freq = 0;
            if (mp.containsKey(key)) freq = mp.get(key); // fetching from the map
            freq++;
            mp.put(key, freq ); // updating the map
        }
            int q;
            System.out.println("Enter number of queries:");
            q = sc.nextInt();
            System.out.println("Enter queries:");
            while (q-- > 0) {
                int number;
                number = sc.nextInt();
                // fetch:
                if (mp.containsKey(number)) System.out.println(mp.get(number));
                else System.out.println(0);
            }

    }
}

