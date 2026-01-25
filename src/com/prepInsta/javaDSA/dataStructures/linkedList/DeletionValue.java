package com.prepInsta.javaDSA.dataStructures.linkedList;
import java.util.*;
import java.io.*;
import java.lang.*;

class DeletionValue{

    static Node insertStart (Node head, int data){
        Node newNode = new Node (data);
        newNode.next = head;
        //changing the new head to this freshly entered node
        head = newNode;
        return head;
    }

    static void insertLast (Node head, int data) {
        Node newNode = new Node (data);
        //need this if there is no node present in linked list at all
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.next = newNode;
    }

    static void insertPosition (int pos, int data, Node head) {
        int size = calcSize (head);
       //If pos is 0 then should use insertStart method
        //If pos is less than 0 then can't enter at all
        //If pos is greater than size then bufferbound issue
        if (pos < 1 || size < pos) {
            System.out.println ("Can't insert," + pos +" is not a valid position\n");
        } else {
            Node newNode = new Node (data);
            //giving any random value
            Node temp = head;
            while (--pos > 0) {
                temp = temp.next;
            }
            //(25)->next = 10 as 12->next is 10
            newNode.next = temp.next;
            // (12)->next = 25
            temp.next = newNode;
            //new node added in b/w 12 and 10
        }
    }

    static Node deleteNode(Node head, int delVal) {
        Node temp = head;
        Node previous = null;

        // Empty list
        if (head == null) {
            System.out.println("List is empty");
            return head;
        }

        // Single node
        if (temp.next == null && temp.data == delVal) {
            head  = null ;
            System.out.println("Value deleted " + delVal);
            return head;
        }

        // Head node deletion
        if (temp.data == delVal) {
             head = temp.next;
            System.out.println("Value deleted " + delVal);
            return head;
        }

        // Search node
        while (temp != null && temp.data != delVal) {
            previous = temp;
            temp = temp.next;
        }

        // Value not found
        if (temp == null) {
            System.out.println("Value not found");
            return head;
        }

        // Delete node
        previous.next = temp.next;
        System.out.println("Value deleted " + delVal);
        return head;
    }


    static void display (Node node) {
        //as linked list will end when Node is Null
        while (node != null) {
            System.out.print (node.data + " ");
            node = node.next;
        }
        System.out.println ();
    }

    static int calcSize (Node node) {
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public static void main (String args[]) {
        Node head = null;
        head = insertStart (head, 12);
        head = insertStart (head, 16);
        head = insertStart (head, 20);

        insertLast (head, 10);
        insertLast (head, 14);
        insertLast (head, 18);
        insertLast (head, 11);

        //Inserts after 3rd position
        insertPosition (3, 25, head);

        display (head);

        //deleting first occurrence of a value in linked list
        head = deleteNode (head, 20);
        head = deleteNode (head, 12);
        head = deleteNode (head, 120);

        System.out.println ("Linked List After Operations : ");

        display (head);

    }
}
