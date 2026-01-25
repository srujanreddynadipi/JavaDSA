package com.prepInsta.javaDSA.dataStructures.queues;
import java.util.ArrayDeque;
import java.util.LinkedList;

class QueuesCollections {
    public static void main (String[] args) {
        // Queue queue = new LinkedList<Integer>();
        LinkedList<Integer> queue = new LinkedList<>();
        // Queue<Integer> queue = new ArrayDeque<Integer>();
        //ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        queue.offer(10);
        queue.offer(20);
        queue.offer(30);
        queue.offer(40);
        queue.offer(50);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println(queue.contains(20));
        System.out.println(queue.contains(40));
        System.out.println(queue.peek());

//        for (Integer integer : queue) {
//            System.out.print(integer + " ");
//        }

        System.out.println();

//        while (!queue.isEmpty()){
//            System.out.print(queue.peek() + " ");
//            queue.poll();
//        }

        while (!queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }

    }

}