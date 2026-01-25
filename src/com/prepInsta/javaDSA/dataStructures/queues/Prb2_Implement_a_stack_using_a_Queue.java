package com.prepInsta.javaDSA.dataStructures.queues;

import java.util.LinkedList;
import java.util.Queue;

public class Prb2_Implement_a_stack_using_a_Queue {
    public static class MyStack {
        private Queue queue;
        public MyStack() {
            queue = new LinkedList();
        }
        public void push(int x) {
            queue.add(x);
            int n = queue.size();
            while (n > 1) {
                queue.add(queue.remove());
                n--;
            }
        }
        public int pop() {
            return (int) queue.remove();
        }
        public int top() {
            return (int) queue.peek();
        }
        public boolean empty() {
            return queue.isEmpty();
        }
    }
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
        System.out.println(stack.pop());
        System.out.println(stack.empty());
    }
}