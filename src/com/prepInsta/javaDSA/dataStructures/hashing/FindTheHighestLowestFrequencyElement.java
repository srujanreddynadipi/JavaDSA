package com.prepInsta.javaDSA.dataStructures.hashing;

import java.util.HashMap;
import java.util.Map;

public class FindTheHighestLowestFrequencyElement {
    public static void frequency(int[] arr){
        HashMap<Integer , Integer> map = new HashMap<>();
        for(int i=0 ; i<arr.length ; i++){
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        // Traverse through the HashMap and print frequencies
        int highest = 0 ;
        int highKey = 0 ;
        int lowest = arr.length ;
        int lowKey = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(highest<entry.getValue()){
                highest = entry.getValue();
                highKey = entry.getKey();
            }
            if(lowest>entry.getValue()){
                lowest = entry.getValue();
                lowKey = entry.getKey();
            }
        }
        System.out.println("highest = " + highKey);
        System.out.println("lowest = " + lowKey);
    }

    public static void main(String[] args) {
        int[] arr = {10,5,10,15,10,5};
        frequency(arr);
    }

    //highest = 10
    //lowest = 15
}
