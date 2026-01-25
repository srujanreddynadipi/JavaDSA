package com.prepInsta.javaDSA.dataStructures.linkedList;

 class Node{
    int data ;
    Node next;
    Node previous;

    Node(int x){
        data = x ;
        next = null;
        previous = null ;
    }
}

public class DoublyLinkedList {
    Node head;

    public void insertFirst( int val ){
        Node newNode = new Node(val);
        newNode.next = head ;
        newNode.previous = null ;
        if(head!=null){
            head.previous = newNode;
        }
        head = newNode ;
    }

    public void insertLast(int val){
        Node newNode = new Node(val);

        //if there is no elements present
        if(head==null){
            head = newNode;
            head.previous = null;
        }else {
            //finding the last node
            Node last = head;
            while (last.next != null) {
                last = last.next;
            }
            //adding pointer of last node to new node
            last.next = newNode;
            newNode.previous = last;
            newNode.next = null;
        }
    }

    public void insertPosition(int data , int index){
        if(index == 0 ){
            insertFirst(data);
            return;
        }
        // finding the size
        int size = 0;
        Node last = head;
        while (last.next != null) {
            last = last.next;
            size++;
        }

        if(index == size ){
            insertLast(data);
            return;
        }

       Node pre = head ;
        for(int i = 1 ; i<index ; i++){
            pre = pre .next ;
        }

        Node newNode = new Node(data);

        Node nextNode = pre.next;   // ✅ save next node

        newNode.next = nextNode;
        newNode.previous = pre;

        pre.next = newNode;
        nextNode.previous = newNode;
    }

    public  void insertValue(int data , int val){

        Node pre = find(val);
        Node newNode = new Node(data);

        Node nextNode = pre.next;   // ✅ save next node

        newNode.next = nextNode;
        newNode.previous = pre;

        pre.next = newNode;
        nextNode.previous = newNode;
    }

    public  void deleteFirst(){
        if (head == null) {
            return; // empty list
        }
        if(head.next == null){
            head = null; // single node
        }
        head  = head.next ;
        head.next.previous = null ;
    }

    public  void deleteLast(){
        if (head == null) {
            return; // empty list
        }
        if(head.next == null){
            head = null;  // single node
            return;
        }

        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.previous.next = null;
        last.previous = null;

    }

    public void deletePosition(int pos) {

        if (head == null) {
            return;
        }

        if (pos == 0) {
            deleteFirst();
            return;
        }

        Node temp = head;
        for (int i = 0; i < pos; i++) {
            if (temp == null) return; // invalid position
            temp = temp.next;
        }

        if (temp.next == null) {
            deleteLast();
            return;
        }

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
    }

    public void deleteValue(int val) {

        if (head == null) {
            return;
        }

        if (head.data == val) {
            deleteFirst();
            return;
        }

        Node temp = head;
        while (temp != null && temp.data != val) {
            temp = temp.next;
        }

        if (temp == null) {
            return; // value not found
        }

        if (temp.next == null) {
            deleteLast();
            return;
        }

        temp.previous.next = temp.next;
        temp.next.previous = temp.previous;
    }

    public Node find(int val){
        Node pre = head ;
        while (pre != null){
            if( pre.data == val){
                return pre;
            }
            pre = pre.next;
        }
        return null;
    }

    public  void display(){
        Node temp = head ;
        Node last = null;

        while(temp != null){
            System.out.print(temp.data+" -> ");
            last = temp ;
            temp=temp.next ;
        }
        System.out.println("END");
    //Print in Reverse
        System.out.println("Print in Reverse");
        while(last != null){
            System.out.print(last.data+" -> ");
            last=last.previous ;
        }
        System.out.println("START");
    }


    public static void main(String[] args) {
        DoublyLinkedList ddl = new DoublyLinkedList();
        ddl.insertFirst(3);
        ddl.insertFirst(4);
        ddl.insertFirst(5);
        ddl.insertFirst(6);
        ddl.insertFirst(7);
        ddl.insertLast(2);
        ddl.insertLast(1);
        ddl.insertPosition(4,4);
        ddl.insertValue(8,7);
        ddl.deleteFirst();
        ddl.deleteLast();
        ddl.deleteValue(4);
        ddl.deletePosition(2);
        ddl.display();

    }

}
