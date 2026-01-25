package com.prepInsta.javaDSA.dataStructures.linkedList;

public class ReverseLinkedList {

    // Definition for singly-linked list
    static class Node {
        int val;
        Node next;

        Node(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Head and Tail for custom linked list
    Node head;
    Node tail;

    // ===============================
    // LOGIC 1: Reverse using TAIL pointer (Rebuild on return)
    // ===============================
    private void reverseUsingTail(Node node) {

        // Base case: last node
        if (node == tail) {
            head = tail;
            return;
        }

        // Go till the end
        reverseUsingTail(node.next);

        // Rebuild list while returning
        tail.next = node;
        tail = node;
        tail.next = null;
    }

    // ===============================
    // LOGIC 2: Standard Recursive Reverse (LeetCode style)
    // ===============================
    public Node reverseStandard(Node head) {

        // Base case: empty list or last node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse remaining list
        Node newHead = reverseStandard(head.next);

        // Fix current node
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // ===============================
    // Utility: Print Linked List
    // ===============================
    void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " -> ");
            node = node.next;
        }
        System.out.println("null");
    }

    // ===============================
    // Utility: Insert at end
    // ===============================
    void insert(int val) {
        Node node = new Node(val);
        if (head == null) {
            head = tail = node;
            return;
        }
        tail.next = node;
        tail = node;
    }

    // ===============================
    // MAIN METHOD
    // ===============================
    public static void main(String[] args) {

        ReverseLinkedList list = new ReverseLinkedList();

        // Build list: 1 -> 2 -> 3 -> 4 -> 5
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        System.out.print("Original List: ");
        list.printList(list.head);

        // -------- Reverse using Tail logic --------
        list.reverseUsingTail(list.head);
        System.out.print("Reversed (Using Tail): ");
        list.printList(list.head);

        // -------- Reverse using Standard recursion --------
        list.head = list.reverseStandard(list.head);
        System.out.print("Reversed Again (Standard): ");
        list.printList(list.head);
    }
}
