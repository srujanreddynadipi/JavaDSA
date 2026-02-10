package com.prepInsta.javaDSA.dataStructures.tree;

public class BSTTraversal {
    // Node structure
    public class Node {
        int data;
        Node left;
        Node right;

        // Constructor
        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Root of BST
    private Node root;

    // Insert value into BST
    public void insert(int value) {
        root = insert(root, value);
    }

    // Recursive insert
    private Node insert(Node node, int value) {

        // Base case
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(node.left, value);
        }
        else if (value > node.data) {
            node.right = insert(node.right, value);
        }

        return node;
    }

    // ---------------- PREORDER ----------------
    // Root -> Left -> Right
    public void preorder() {
        System.out.print("Preorder Traversal: ");
        preorder(root);
        System.out.println();
    }

    private void preorder(Node node) {
        if (node == null) return;

        System.out.print(node.data + " ");
        preorder(node.left);
        preorder(node.right);
    }

    // ---------------- INORDER ----------------
    // Left -> Root -> Right
    public void inorder() {
        System.out.print("Inorder Traversal: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node == null) return;

        inorder(node.left);
        System.out.print(node.data + " ");
        inorder(node.right);
    }

    // ---------------- POSTORDER ----------------
    // Left -> Right -> Root
    public void postorder() {
        System.out.print("Postorder Traversal: ");
        postorder(root);
        System.out.println();
    }

    private void postorder(Node node) {
        if (node == null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + " ");
    }

    // ---------------- MAIN METHOD ----------------
    public static void main(String[] args) {

        BSTTraversal bst = new BSTTraversal();

        int[] values = {10, 5, 15, 3, 7, 12, 18};

        for (int val : values) {
            bst.insert(val);
        }

        bst.preorder();
        bst.inorder();
        bst.postorder();
    }
}
