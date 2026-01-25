package com.prepInsta.javaDSA.dataStructures.linkedList;

public class FindStartingPointOfCycle {

    // Definition for singly-linked list
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public ListNode detectCycle(ListNode head) {

            if (head == null) return null;

            int size = 0;
            ListNode fast = head;
            ListNode slow = head;

            // Step 1: Detect cycle using Floyd’s algorithm
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;

                if (fast == slow) {
                    break; // cycle detected
                }
            }

            // IMPORTANT: If no cycle exists
            if (fast == null || fast.next == null) {
                return null;
            }

            // Step 2: Find the length of the cycle
            ListNode temp = slow;
            do {
                slow = slow.next;
                size++;
            } while (temp != slow);

            // Step 3: Find starting node of the cycle
            ListNode f = head;
            ListNode s = head;

            // Move 's' ahead by cycle length
            while (size > 0) {
                s = s.next;
                size--;
            }

            // Move both pointers until they meet
            while (f != s) {
                f = f.next;
                s = s.next;
            }

            // 'f' (or 's') is the starting node of the cycle
            return f;
        }
    }

    // Optional: main method for testing
    public static void main(String[] args) {

        // Create linked list: 1 -> 2 -> 3 -> 4
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        // Create cycle: 4 -> 2
        head.next.next.next.next = head.next;

        Solution solution = new Solution();
        ListNode cycleStart = solution.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle detected");
        }
    }
}
