package com.prepInsta.javaDSA.Maths;

public class Armstrong {


    public static boolean armstrong(int x) {
        if (x <= 0) return false;

        int original = x;
        int digits = 0;

        // Count digits
        for (int temp = x; temp > 0; temp /= 10) {
            digits++;
        }

        int sum = 0;
        while (x > 0) {
            int digit = x % 10;
            sum += Math.pow(digit, digits);
            x /= 10;
        }

        return sum == original;
    }

    public static void main(String[] args) {
        System.out.println(armstrong(153)); // true
        System.out.println(armstrong(155)); // false
    }
}
