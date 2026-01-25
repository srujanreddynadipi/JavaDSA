package com.prepInsta.javaDSA.dataStructures.linkedList;

class Deletionposition {

    static Node insert (Node head, int data) {
        Node newNode = new Node (data);
        newNode.next = head;
        //changing the new head to this freshly entered node
        head = newNode;
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

    static Node deletenode (Node head, int pos) {
        Node temp = head;
        Node previous = null;

        //if the head node itself needs to be deleted
        int size = calcSize (head);
        if (pos < 1 || pos > size)
        {
            System.out.println ("Enter valid position");
            return head;
        }
        if (pos == 1) {
            //Case 1 head becomes 30
            head = temp.next;	//changing head to next in the list
            System.out.println ("Value deleted: " + temp.data);
            return head;
        }
        //run until we find the value to be deleted in the list
        while (--pos > 0) {
            //store previous link node as we need to change its next val
            previous = temp;
            temp = temp.next;
        }

        // Case 2: (24)->next = 16 (as 20->next = 16)
        // Case 3: (16)->next = NULL (as 12->next = NULL)
        previous.next = temp.next;
        System.out.println ("Value deleted: " + temp.data);
        return head;
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

        head = insert (head, 12);
        head = insert (head, 16);
        head = insert (head, 20);
        head = insert (head, 24);
        head = insert (head, 30);
        head = insert (head, 22);
        System.out.println ("Linked List Before Operations : ");
        display (head);
        //deleting first occurrence of a value in linked list
        head = deletenode (head, 1);
        display (head);

        head = deletenode (head, 3);
        display (head);

        head = deletenode (head, 4);
        display (head);

        head = deletenode (head, -1);
        head = deletenode (head, 10);
        display (head);

    }
}