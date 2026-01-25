package com.prepInsta.javaDSA.dataStructures.queues;

import java.util.*;
import java.util.Queue;

public class Prb1ReverseQueue {

    static Queue queue;

     static void reverse_queue(){
        Stack stack = new Stack<>();
        while(!queue.isEmpty()){
            stack.add(queue.peek());
            queue.remove();
        }

        while(!stack.isEmpty()){
            queue.add(stack.peek());
            stack.pop();
        }
    }

    public static void main(String[] args)
    {
        queue = new LinkedList();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        queue.add(6);
        queue.add(7);
        queue.add(8);
        queue.add(9);
        queue.add(10);



        reverse_queue();

        while (!queue.isEmpty()){
            System.out.print(queue.peek()+ " ");
            queue.remove();
        }
        //10 9 8 7 6 5 4 3 2 1

    }


    //class Main {
    //    public static void reverseQueue(Queue<Integer> q) {
    //        Stack<Integer> stack = new Stack<>();
//
    //        // Step 1: Move all elements from queue to stack
    //        while (!q.isEmpty()) {
    //            stack.push(q.poll());
    //        }
//
    //        // Step 2: Move elements back from stack to queue
    //        while (!stack.isEmpty()) {
    //            q.add(stack.pop());
    //        }
    //    }
//
    //    public static void main(String[] args) {
    //        Queue<Integer> q = new LinkedList<>();
//
    //        for (int i = 1; i <= 10; i++) {
    //            q.add(i);
    //        }
//
    //        reverseQueue(q);
//
    //        // Print reversed queue
    //        while (!q.isEmpty()) {
    //            System.out.print(q.poll() + " ");
    //        }
    //    }
    //}

}
