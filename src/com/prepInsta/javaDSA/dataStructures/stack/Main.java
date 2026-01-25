package com.prepInsta.javaDSA.dataStructures.stack;

public class Main {
    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(5);
        s.push(10);
        s.push(15);
        s.push(20);
        System.out.println(s.pop());
        System.out.println(s.peek());
        System.out.println(s.size());
        String result;
        System.out.println(result = (s.isEmpty()) ? "Stack is Empty" : "Stack is not Empty");
        System.out.println(result = (s.isFull()) ? "Stack is Full" : "Stack is not Full");
    }
}

class Stack{
    static final int MAX = 10;
    int top ;
    int[] a = new int[MAX];

    Stack(){
        top=-1;
    }

    public boolean push(int x){
        if(top>=(MAX-1)){
            System.out.println("Stack OverFlow");
            return false;
        }else{
            a[++top] = x ;
            System.out.println(x+" pushed sucessfully");
            return true;
        }
    }

    public int  pop(){
        if(top<0){
            System.out.println("Stack underFlow");
            return 0;
        }else{
            int x = a[top--];
            return x;
        }
    }

    public char peek(){
        if(top<0){
            System.out.println("Stack underFlow");
            return 0;
        }else{
            int x = a[top];
            return (char) x;
        }
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top==-1;
    }

    public boolean isFull(){
        return top==MAX-1;
    }
}