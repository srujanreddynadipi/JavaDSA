package com.prepInsta.javaDSA.dataStructures.linkedList;

// Node class represents a single element of the Linked List
/*class Node {
    int data;               // Stores the data/value of the node
    Node next;              // Reference to the next node in the list

    Node(int x) {            // Constructor to initialize node
        data = x;            // Assign data
        next = null;         // Initially next is null
    }
}*/

public class Insertion {

    // Insert a node at the beginning of the linked list
    static Node insertStart(Node head, int data) {
        Node newNode = new Node(data);   // Create new node
        newNode.next = head;             // Point new node to old head
        head = newNode;                  // Update head
        return head;                     // Return updated head
    }

    // Insert a node at the end of the linked list
    static Node insertLast(Node head, int data) {
        Node newNode = new Node(data);   // Create new node

        if (head == null) {              // If list is empty
            head = newNode;              // New node becomes head
            return head;
        }

        Node temp = head;                // Temporary pointer to traverse list
        while (temp.next != null) {      // Traverse till last node
            temp = temp.next;
        }

        temp.next = newNode;             // Link last node to new node
        return head;                     // Return unchanged head
    }

    // Insert a node at a specific position (1-based index)
    static Node insertPosition(int pos, int data, Node head) {

        int size = calcSize(head);       // Calculate size of linked list

        if (pos < 1 || pos > size + 1) { // Validate position
            System.out.println("Can't insert, " + pos + " is not a valid position");
        } else {
            Node newNode = new Node(data); // Create new node
            Node temp = head;              // Start from head

            while (--pos > 0) {            // Move to (pos-1)th node
                temp = temp.next;
            }

            newNode.next = temp.next;      // Link new node to next node
            temp.next = newNode;           // Link previous node to new node
        }
        return head;                       // Return head
    }

    // Display all elements of the linked list
    static void display(Node node) {
        while (node != null) {             // Traverse until end
            System.out.print(node.data + " "); // Print data
            node = node.next;              // Move to next node
        }
        System.out.println();              // New line after display
    }

    // Calculate the size (number of nodes) of the linked list
    static int calcSize(Node node) {
        int size = 0;                      // Initialize size counter
        while (node != null) {             // Traverse list
            node = node.next;              // Move to next node
            size++;                        // Increment count
        }
        return size;                       // Return total size
    }

    public static void main(String args[]) {

        Node head = null;                  // Initialize empty linked list

        head = insertStart(head, 12);      // Insert at beginning
        head = insertStart(head, 16);
        head = insertStart(head, 20);

        head = insertLast(head, 10);       // Insert at end
        head = insertLast(head, 14);
        head = insertLast(head, 18);
        head = insertLast(head, 11);

        insertPosition(3, 25, head);       // Insert 25 at position 3

        display(head);                     // Display final linked list
    }
}
