package com.prepInsta.javaDSA.dataStructures.tree.Problems;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.ArrayList;


public class LeetCode_107_BinaryTreeLevelOrderTraversal_II {
    // -----------------------------------------
    // Definition for a binary tree node
    // -----------------------------------------
    static class TreeNode {
        int val;              // Value of node
        TreeNode left;        // Left child
        TreeNode right;       // Right child

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

    // -----------------------------------------
    // Level Order Traversal from Bottom to Top
    // -----------------------------------------
    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        // Final result list
        List<List<Integer>> result = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) {
            return result;
        }

        // Queue for Breadth First Search
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root node to queue
        queue.offer(root);

        // Continue while nodes exist
        while (!queue.isEmpty()) {

            // Number of nodes at current level
            int levelSize = queue.size();

            // Stores nodes of current level
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            // Traverse all nodes of this level
            for (int i = 0; i < levelSize; i++) {

                // Remove front node from queue
                TreeNode currentNode = queue.poll();

                // Add node value to level list
                currentLevel.add(currentNode.val);

                // Add left child to queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add right child to queue
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Insert level at beginning of result
            // This makes traversal bottom-up
            result.add(0, currentLevel);
        }

        // Return final result
        return result;
    }

    // -----------------------------------------
    // Main method for testing
    // -----------------------------------------
    public static void main(String[] args) {

        LeetCode_107_BinaryTreeLevelOrderTraversal_II obj = new LeetCode_107_BinaryTreeLevelOrderTraversal_II();

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

        // Call method
        List<List<Integer>> result = obj.levelOrderBottom(root);

        // Print result
        System.out.println(result);
    }
}
