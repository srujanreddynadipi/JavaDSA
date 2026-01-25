package com.prepInsta.javaDSA.dataStructures.stack;

import java.util.ArrayList;

public class StackArrayList {
    public static void main(String[] args) {
        push(20);
        push(20);
        push(20);
        System.out.println(pop());
        System.out.println(pop());
        System.out.println(peek());
        System.out.println(size());


    }

    static ArrayList<Integer> list  = new ArrayList<>();

    static void push(int x){
        list.add(x);
    }

   static int pop(){
        if(isEmpty()){
            System.out.println("Stack UnderFlow");
            return  Integer.MIN_VALUE;
        }
        int res = list.get(list.size()-1);
        list.remove(list.size()-1);
        return res;
    }

     static int peek(){
        if(isEmpty()){
            System.out.println("Stack UnderFlow");
            return  Integer.MIN_VALUE;
        }
        int res = list.get(list.size()-1);
        return res;
    }

    static int size(){
        return list.size();
    }

    static boolean isEmpty(){
        return list.isEmpty();
    }
}
