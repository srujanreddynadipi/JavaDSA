package com.prepInsta.javaDSA.dataStructures.linkedList;

import com.sun.security.jgss.GSSUtil;

public class CycleDetectionInLIst {
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
        int size;

        public boolean hasCycle(ListNode head) {

            if (head == null) return false;

            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;          // move 1 step
                fast = fast.next.next;    // move 2 steps

                if (slow == fast) {
                    return true;          // cycle detected
                }
            }
            return false;                 // no cycle
        }

        public int lengthOfCycle(ListNode head){
            ListNode fast = head ;
            ListNode slow = head ;

            while(fast != null && fast.next != null){
                slow = slow.next ;
                fast = fast.next.next;
                if(fast == slow){
                    break;
                }
            }

            ListNode temp = slow ;
            do{
                slow = slow.next;
                size++;
            }
            while(temp != slow);
            return size;
        }
    }



    public static void main(String[] args) {

        // -------- Test Case 1: Cycle exists --------
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);

        // Creating a cycle: last node points to node with value 2
        head1.next.next.next.next = head1.next;

        Solution solution = new Solution();
        System.out.println("Cycle present (Test 1): " + solution.hasCycle(head1));

        System.out.println("Length of cycle "+ solution.lengthOfCycle(head1));

        // -------- Test Case 2: No cycle --------
        ListNode head2 = new ListNode(10);
        head2.next = new ListNode(20);
        head2.next.next = new ListNode(30);

        System.out.println("Cycle present (Test 2): " + solution.hasCycle(head2));


    }
}
