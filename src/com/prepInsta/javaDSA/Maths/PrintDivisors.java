package com.prepInsta.javaDSA.Maths;

import java.util.List;
import java.util.*;

public class PrintDivisors {
    public static List<Integer> divisors(int n){

        List<Integer> res = new ArrayList<>();

        for(int i=1 ; i*i <= n ; i++){
            if(n%i==0){
                res.add(i);

                if(i!=n/i){
                    res.add(n/i);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> result = divisors(36);

        for(int val : result){
            System.out.print(val+" ");
        }
        System.out.println();
    }
}
