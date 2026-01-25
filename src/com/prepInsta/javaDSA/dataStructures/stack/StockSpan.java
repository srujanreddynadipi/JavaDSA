package com.prepInsta.javaDSA.dataStructures.stack;
import java.util.Stack;

public class StockSpan {
    static void stockSpan(int[] arr, int size) {
        Stack<Integer> s = new Stack<>();
        s.add(0);
        System.out.print(1+" ");
        for(int i=1 ; i<size ; i++){
            while(s.isEmpty()==false && arr[s.peek()]<arr[i] ){
                    s.pop();
            }
            int span = s.isEmpty()?i+1:i-s.peek();
            System.out.print(span +" ");
            s.push(i);
        }
    }
    public static void main(String[] args)
    {
        int[] arr = {100, 20, 30, 60, 38, 36, 32, 55, 80, 50, 120};
        int size = arr.length;
        stockSpan(arr, size);

    }
}
