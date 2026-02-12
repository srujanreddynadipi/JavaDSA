package com.prepInsta.javaDSA.dataStructures.tree.Problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LeetCode_102_BFS_BinaryTreeLevelOrderTraversal {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();  // store the list of list of each level
            if (root == null) return result;  // edge case

            Queue<TreeNode> queue = new LinkedList<>();   // queue to store the nodes of each level
            queue.offer(root);                            //adding rot node to the queue

            while (!queue.isEmpty()) {                      //run until queue is empty
                int levelSize = queue.size();               //number of nodes in the current level
                List<Integer> currentLevel = new ArrayList<>(levelSize);  //list to store the values of the current level

                for (int i = 0; i < levelSize; i++) {
                    TreeNode currentNode = queue.poll();                //remove the node from the queue and add into currentNode
                    currentLevel.add(currentNode.val);                  //add the value of the current node to the current level list

                    if (currentNode.left != null) queue.offer(currentNode.left);  //if left child is not null add it to the queue
                    if (currentNode.right != null) queue.offer(currentNode.right); // if right child is not null add it to the queue
                }

                result.add(currentLevel);  //add the current level list to the result list after processing all nodes of the current level
            }

            return result;  //return the list of list of each level
        }

    public static void main(String[] args) {
        LeetCode_102_BFS_BinaryTreeLevelOrderTraversal solution = new LeetCode_102_BFS_BinaryTreeLevelOrderTraversal();
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);

        List<List<Integer>> levels = solution.levelOrder(root);
        System.out.println(levels); // Output: [[1], [2, 3], [4, 5]]
    }


}
