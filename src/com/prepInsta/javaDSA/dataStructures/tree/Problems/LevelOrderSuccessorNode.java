package com.prepInsta.javaDSA.dataStructures.tree.Problems;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessorNode {

    // ------------------------------------------
    // Definition of TreeNode
    // ------------------------------------------
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    // ------------------------------------------
    // Method to find Level Order Successor
    // ------------------------------------------
    public int levelOrderSuccessor(TreeNode root, int value) {

        // If tree is empty
        if (root == null) {
            return -1;
        }

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Traverse tree level by level
        while (!queue.isEmpty()) {

            // Remove current node
            TreeNode currentNode = queue.poll();

            // Add children to queue
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }

            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            // If target value found
            if (currentNode.val == value) {

                // Next node in queue is successor
                if (!queue.isEmpty()) {
                    return queue.peek().val;
                } else {
                    return -1; // No successor
                }
            }
        }

        return -1; // Value not found
    }

    // ------------------------------------------
    // Main Method (Testing)
    // ------------------------------------------
    public static void main(String[] args) {

        LevelOrderSuccessorNode obj = new LevelOrderSuccessorNode();

        /*
                3
              /   \
             9     20
                  /  \
                 15   7
         */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int target = 9;

        int successor = obj.levelOrderSuccessor(root, target);

        System.out.println("Level Order Successor of " + target + " is: " + successor);
    }
}
