package com.prepInsta.javaDSA.dataStructures.queues;

public class CircularQueue {
    int capacity ;
    int front ;
    int rear ;
    int[] queue ;
    CircularQueue(int cap){
        capacity = cap;
        front = -1;
        rear = -1 ;
        queue = new int[capacity];
    }
    boolean isFull(){
        return (front==0 && rear==capacity-1 )||( front == rear + 1 );
    }

    boolean isEmpty(){
        return (front== -1 );
    }

    void enqueue(int item){
        if(isFull()){
            return;
        }else{
            if(front == -1 )
                front = 0 ;
            rear = (rear + 1 )%capacity ;
            queue[rear] = item;
            System.out.println(item+" queued sucessfully");
        }
    }

    int dequeue(){
        if(isEmpty()){
            System.out.println("cannot be removed queue is empty");
            return Integer.MIN_VALUE ;
        }else{
            int  item = queue[front];
            if(front == rear) {
                front = rear = -1;
            }else{
                front = (front+1)%capacity;
            }
            System.out.println(item + " Dequeued ");
            return item ;
        }
    }

    // Method to get front of queue
    int front()
    {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return queue[front];
    }

    // Method to get rear of queue
    int rear()
    {
        if (isEmpty())
            return Integer.MIN_VALUE;

        return queue[rear];
    }

    void display(){
        int i ;
        if(isEmpty()){
            System.out.println( "queue is empty");
        }else {
            for(i=front ; i<rear ; i =  (i+1)%capacity){
                System.out.print(queue[i]+" ");
            }
            System.out.println(queue[i]);
        }
    }

    public static void main(String[] args)
    {
        CircularQueue queue = new CircularQueue(6);

        queue.dequeue();//Underflow condition

        queue.enqueue(12);
        queue.enqueue(14);
        queue.enqueue(16);
        queue.enqueue(18);
        queue.enqueue(20);

        queue.display();
        queue.dequeue();
        queue.dequeue();

        queue.display();

        queue.enqueue(22);
        queue.enqueue(24);
        queue.enqueue(26);
        queue.enqueue(28);//Overflow condition
        queue.display();

    }
}
