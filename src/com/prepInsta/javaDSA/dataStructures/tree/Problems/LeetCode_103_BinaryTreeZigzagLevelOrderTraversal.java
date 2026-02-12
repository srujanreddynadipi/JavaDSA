package com.prepInsta.javaDSA.dataStructures.tree.Problems;
import java.util.*;

public class LeetCode_103_BinaryTreeZigzagLevelOrderTraversal {


    // -----------------------------------------
    // Definition of TreeNode
    // -----------------------------------------
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

    // -----------------------------------------
    // Zigzag Level Order Traversal
    // -----------------------------------------
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // Final result list
        List<List<Integer>> result = new ArrayList<>();

        // If tree empty
        if (root == null) {
            return result;
        }

        // Queue for BFS
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Flag to track direction
        boolean leftToRight = true;

        // BFS traversal
        while (!queue.isEmpty()) {

            int levelSize = queue.size();

            // Deque allows add at both ends
            Deque<Integer> currentLevel = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {

                // Remove node
                TreeNode currentNode = queue.poll();

                // Insert value based on direction
                if (leftToRight) {
                    currentLevel.addLast(currentNode.val); // normal
                } else {
                    currentLevel.addFirst(currentNode.val); // reverse
                }

                // Always insert children left -> right
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }

                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // Add current level to result
            result.add(new ArrayList<>(currentLevel));

            // Switch direction
            leftToRight = !leftToRight;
        }

        return result;
    }

    // -----------------------------------------
    // Main method (Testing)
    // -----------------------------------------
    public static void main(String[] args) {

        LeetCode_103_BinaryTreeZigzagLevelOrderTraversal obj = new LeetCode_103_BinaryTreeZigzagLevelOrderTraversal();

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

        List<List<Integer>> result = obj.zigzagLevelOrder(root);

        System.out.println(result);
    }
}
