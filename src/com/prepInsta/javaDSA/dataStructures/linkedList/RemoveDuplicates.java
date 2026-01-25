package com.prepInsta.javaDSA.dataStructures.linkedList;

public class RemoveDuplicates {

    // Definition for singly-linked list.
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return head;
            }

            ListNode current = head;

            while (current.next != null) {
                if (current.val == current.next.val) {
                    current.next = current.next.next; // skip duplicate
                } else {
                    current = current.next;
                }
            }
            return head;
        }
    }

    // Helper method to print linked list
    static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        // Creating sorted linked list: 1 -> 1 -> 2 -> 3 -> 3
        ListNode head = new ListNode(1,
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(3,
                                        new ListNode(3)))));

        System.out.print("Original List: ");
        printList(head);

        Solution solution = new Solution();
        head = solution.deleteDuplicates(head);

        System.out.print("After Removing Duplicates: ");
        printList(head);
    }
}
