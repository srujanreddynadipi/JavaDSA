package com.prepInsta.javaDSA.dataStructures.tree.Problems;

public class LeetCode_116_PopulatingNextRightPointersinEachNode {
}
// ------------------------------------------------------
// Definition for a Node (Perfect Binary Tree)
// ------------------------------------------------------
class Node {

    public int val;      // Value of the node
    public Node left;    // Left child
    public Node right;   // Right child
    public Node next;    // Pointer to next right node

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}


// ------------------------------------------------------
// Solution Class
// ------------------------------------------------------
class Solution {

    public Node connect(Node root) {

        // If tree is empty, return null
        if (root == null) {
            return null;
        }

        /*
           Since this is a PERFECT binary tree:
           - Every parent has exactly two children
           - All leaves are at same level

           We can connect nodes without using extra space.
        */

        // Start from the root (leftmost node of each level)
        Node leftMost = root;

        /*
           We stop when we reach leaf level.
           If leftMost.left is null → we are at last level.
        */
        while (leftMost.left != null) {

            // Traverse nodes at current level
            Node current = leftMost;

            while (current != null) {

                // -------------------------------------------------
                // 1️⃣ Connect left child to right child
                // Example: 2 → 3
                // -------------------------------------------------
                current.left.next = current.right;

                // -------------------------------------------------
                // 2️⃣ Connect right child to next subtree's left child
                // Example: 3 → 4
                // Only if next parent exists
                // -------------------------------------------------
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                // Move to next node in same level
                current = current.next;
            }

            // Move down to next level (leftmost node)
            leftMost = leftMost.left;
        }

        return root;
    }


    // ------------------------------------------------------
    // Main Method for Testing
    // ------------------------------------------------------
    public static void main(String[] args) {

        /*
                Perfect Binary Tree Example:

                        1
                      /   \
                     2     3
                    / \   / \
                   4   5 6   7
        */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        Solution sol = new Solution();
        sol.connect(root);

        // Printing next pointers of second level
        System.out.println(root.left.val + " -> " +
                (root.left.next != null ? root.left.next.val : "null"));

        System.out.println(root.left.left.val + " -> " +
                (root.left.left.next != null ? root.left.left.next.val : "null"));
    }
}
