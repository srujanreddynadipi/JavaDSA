package com.prepInsta.javaDSA.dataStructures.linkedList;


    public class MergeTwoSortedList {

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
            public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

                // Dummy node (sentinel)
                ListNode dummy = new ListNode();
                ListNode tail = dummy;

                while (list1 != null && list2 != null) {
                    if (list1.val < list2.val) {
                        tail.next = list1;
                        list1 = list1.next;
                    } else {
                        tail.next = list2;
                        list2 = list2.next;
                    }
                    tail = tail.next;
                }                // Attach remaining nodes
                tail.next = (list1 != null) ? list1 : list2;

                // Skip dummy node
                return dummy.next;
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

            // list1: 1 -> 3 -> 5
            ListNode list1 = new ListNode(1,
                    new ListNode(3,
                            new ListNode(5)));

            // list2: 2 -> 4 -> 6
            ListNode list2 = new ListNode(2,
                    new ListNode(4,
                            new ListNode(6)));

            System.out.print("List 1: ");
            printList(list1);

            System.out.print("List 2: ");
            printList(list2);

            Solution solution = new Solution();
            ListNode merged = solution.mergeTwoLists(list1, list2);

            System.out.print("Merged List: ");
            printList(merged);
        }
    }
