package com.prepInsta.javaDSA.dataStructures.linkedList;

class ReversedLinkedListPointers {

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

    public ListNode reverseList(ListNode head) {

        // Base case
        if (head == null || head.next == null) {
            return head;
        }

        ListNode previous = null;
        ListNode present = head;

        while (present != null) {

            ListNode next = present.next; // save next node

            present.next = previous;      // reverse link
            previous = present;           // move previous
            present = next;               // move present
        }

        return previous; // new head
    }

    // Optional main method for testing
    public static void main(String[] args) {

        ReversedLinkedListPointers solution = new ReversedLinkedListPointers();

        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5)))));

        ListNode reversed = solution.reverseList(head);

        // Print reversed list
        while (reversed != null) {
            System.out.print(reversed.val + " -> ");
            reversed = reversed.next;
        }
        System.out.println("null");
    }
}
