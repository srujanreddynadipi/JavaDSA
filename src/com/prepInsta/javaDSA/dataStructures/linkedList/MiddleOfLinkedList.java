package com.prepInsta.javaDSA.dataStructures.linkedList;

public class MiddleOfLinkedList {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static class Solution {
        public ListNode middleNode(ListNode head) {

            ListNode temp = head;
            int size = 0;

            // Step 1: Count the size of the linked list
            while (temp != null) {
                size++;
                temp = temp.next;
            }

            // Step 2: Calculate middle position
            int mid = (size / 2) + 1;   // works for both even & odd

            // Step 3: Move to middle node
            temp = head;
            for (int i = 1; i < mid; i++) {
                temp = temp.next;
            }

            return temp;
        }
    }

    // Helper method to print linked list
    static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " -> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Create linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5,
                                                new ListNode(6))))));

        System.out.print("Linked List: ");
        printList(head);

        Solution solution = new Solution();
        ListNode middle = solution.middleNode(head);

        System.out.println("Middle Node Value: " + middle.val);
    }
}
