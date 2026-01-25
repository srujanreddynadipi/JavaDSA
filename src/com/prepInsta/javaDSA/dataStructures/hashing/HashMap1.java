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
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // ✅ Step 1: Build HashMap
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = arr[i];
            mp.put(key, mp.getOrDefault(key, 0) + 1);
        }

        // ✅ Step 2: Handle queries
        System.out.println("Enter number of queries:");
        int q = sc.nextInt();

        System.out.println("Enter queries:");
        while (q-- > 0) {
            int number = sc.nextInt();
            System.out.println(mp.getOrDefault(number, 0));
        }
    }
}
