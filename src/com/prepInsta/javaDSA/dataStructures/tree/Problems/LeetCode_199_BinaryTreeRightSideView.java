package com.prepInsta.javaDSA.dataStructures.tree.Problems;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_199_BinaryTreeRightSideView {
    // -----------------------------------------
    // Definition for Binary Tree Node
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
    // Right Side View using Level Order Traversal
    // -----------------------------------------
    public List<Integer> rightSideView(TreeNode root) {

        // Final result list
        List<Integer> result = new ArrayList<>();

        // If tree is empty
        if (root == null) {
            return result;
        }

        // Queue for BFS traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Add root to queue
        queue.offer(root);

        // Traverse level by level
        while (!queue.isEmpty()) {

            // Number of nodes at current level
            int levelSize = queue.size();

            // List to store current level nodes
            List<Integer> currentLevel = new ArrayList<>(levelSize);

            // Process all nodes of this level
            for (int i = 0; i < levelSize; i++) {

                // Remove front node
                TreeNode currentNode = queue.poll();

                // Store its value
                currentLevel.add(currentNode.val);

                // Add left child
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                // Add right child
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // The last node of this level
            // represents the rightmost node
            int last = currentLevel.get(currentLevel.size() - 1);

            // Add it to result
            result.add(last);
        }

        return result;
    }

    // -----------------------------------------
    // Main Method for Testing
    // -----------------------------------------
    public static void main(String[] args) {

        /*
                Example Tree:

                        1
                      /   \
                     2     3
                      \     \
                       5     4

                Right Side View → [1, 3, 4]
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        LeetCode_199_BinaryTreeRightSideView obj = new LeetCode_199_BinaryTreeRightSideView();
        List<Integer> result = obj.rightSideView(root);

        System.out.println(result);
    }
}
