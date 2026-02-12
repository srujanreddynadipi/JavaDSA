package com.prepInsta.javaDSA.dataStructures.tree.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_637_AverageofLevelsinBinaryTree {

    // --------------------------------------------------
    // TreeNode class (structure of each node in tree)
    // --------------------------------------------------
    static class TreeNode {
        int val;          // value of node
        TreeNode left;    // left child
        TreeNode right;   // right child

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    // --------------------------------------------------
    // Method to find average of each level
    // --------------------------------------------------
    public List<Double> averageOfLevels(TreeNode root) {

        // List to store final averages
        List<Double> result = new ArrayList<>();

        // If tree is empty, return empty list
        if (root == null) {
            return result;
        }

        // Queue for Level Order Traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root node into queue
        queue.offer(root);

        // Continue until all levels are processed
        while (!queue.isEmpty()) {

            // Number of nodes at current level
            int levelSize = queue.size();

            // Stores sum of values at current level
            double sum = 0;

            // Traverse all nodes of current level
            for (int i = 0; i < levelSize; i++) {

                // Remove front node from queue
                TreeNode currentNode = queue.poll();

                // Add its value to sum
                sum += currentNode.val;

                // If left child exists, add to queue
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // If right child exists, add to queue
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Calculate average for this level
            double average = sum / levelSize;

            // Store in result list
            result.add(average);
        }

        // Return list of averages
        return result;
    }

    // --------------------------------------------------
    // Main method for testing
    // --------------------------------------------------
    public static void main(String[] args) {

        LeetCode_637_AverageofLevelsinBinaryTree obj =
                new LeetCode_637_AverageofLevelsinBinaryTree();

        /*
                Example Tree:
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
        List<Double> averages = obj.averageOfLevels(root);

        // Print result
        System.out.println("Average of each level: " + averages);
    }
}
