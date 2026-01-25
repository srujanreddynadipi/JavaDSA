package com.prepInsta.javaDSA.dataStructures.hashing;

import java.util.Scanner;

public class CharecterHashing {

    //Lower case letters hashing
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int[] hash = new int[26];
        for(int i=0 ; i<str.length() ; i++){;
            hash[str.charAt(i) - 'a']++;
        }

        System.out.println("Enter number of queries:");
        int userinputsize = sc.nextInt();
        System.out.println("Enter queries:");
        while (userinputsize-- > 0) {
            char c;
            c = sc.next().charAt(0);
            // fetch:
            System.out.println(hash[c - 'a']);
        }

        //all characters hashing
       /* public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            String s;
            s = sc.next();

            //precompute:
            int[] hash = new int[256];
            for (int i = 0; i < s.length(); i++) {
                hash[s.charAt(i)]++;
            }

            int q;
            q = sc.nextInt();
            while (q-- > 0) {
                char c;
                c = sc.next().charAt(0);
                // fetch:
                System.out.println(hash[c]);
            }
        }*/

    }
}
