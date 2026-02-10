package com.prepInsta.javaDSA.dataStructures.tree;

public class BinarySearchTree {

    // Node class represents each node in the BST
    public class Node {
        int data;
        Node left;
        Node right;
        int height;

        // Constructor to initialize node
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 0; // leaf node height = 0
        }
    }

    // Root node of the BST
    private Node root;

    // Returns height of a node
    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    // Check if tree is empty
    public boolean isEmpty() {
        return root == null;
    }

    // Insert multiple values
    public void populate(int[] nums) {
        for (int num : nums) {
            insertValue(num);
        }
    }

    public void sortedPopulate(int[] nums) {
        sortedPopulate(nums, 0, nums.length - 1);
    }

    private void sortedPopulate(int[] nums , int start , int end){
        if(start > end){
            return ;
        }
        int mid = start + (end - start) / 2 ;
        insertValue(nums[mid]);
        sortedPopulate(nums , start , mid-1);
        sortedPopulate(nums , mid+1 , end);
    }

    // Insert a single value
    public void insertValue(int value) {
        root = insert(root, value);
    }

    // Recursive insert method
    private Node insert(Node node, int value) {

        // Base case: empty position found
        if (node == null) {
            return new Node(value);
        }

        // BST property
        if (value < node.data) {
            node.left = insert(node.left, value);
        } else if (value > node.data) {
            node.right = insert(node.right, value);
        }

        // Update height
        node.height = Math.max(height(node.left), height(node.right)) + 1;

        return node;
    }

    // Check if tree is balanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }

        int diff = Math.abs(height(node.left) - height(node.right));

        return diff <= 1 &&
                isBalanced(node.left) &&
                isBalanced(node.right);
    }

    // Display tree structure
    public void display() {
        display(root, "Root");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }

        System.out.println(details + " : " + node.data);

        display(node.left, "Left child of " + node.data);
        display(node.right, "Right child of " + node.data);
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int[] nums = {10, 5, 15, 3, 7, 12, 18};

        int[] sortedNums = {3, 5, 7, 10, 12, 15, 18};

        bst.populate(nums);
        bst.display();

        // Clear the tree and insert sorted values to create a balanced BST
        bst.sortedPopulate(sortedNums);
        bst.display();

        System.out.println("Is tree balanced? " + bst.isBalanced());
    }
}
