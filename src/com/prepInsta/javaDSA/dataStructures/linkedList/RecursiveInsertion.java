package com.prepInsta.javaDSA.dataStructures.linkedList;


public class RecursiveInsertion {
    Node head;
    private class Node{
        int data;
        Node next ;
        Node(int x){
            data = x ;
        }
        Node(int x , Node next){
            data = x ;
            next = next ;
        }
    }

     public Node insertStart(int data) {
         Node newNode = new Node(data);   // Create new node
        newNode.next = head;             // Point new node to old head
        head = newNode;                  // Update head
        return head;                     // Return updated head
    }
    
    public  void RecursiveInsertion(int val ,int index){
        head = RecursiveInsertion(val,index ,head);
    }

    private Node RecursiveInsertion(int val ,int index , Node node){
        if(index == 0){
            Node newNode = new Node(val,node);
            return  newNode ;
        }
        node.next = RecursiveInsertion(val , index-1 , node.next);
        return node ;
    }

     void display() {
        Node node = head;
        while (node != null) {             // Traverse until end
            System.out.print(node.data + " "); // Print data
            node = node.next;              // Move to next node
        }
        System.out.println();              // New line after display
    }

    public static void main(String[] args) {
        RecursiveInsertion ri = new RecursiveInsertion();
        ri.insertStart(1);
        ri.insertStart(2);
        ri.insertStart(3);
        ri.RecursiveInsertion(4,3);
        ri.display();

    }

}
