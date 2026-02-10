package com.prepInsta.javaDSA.dataStructures.tree;

import java.util.Scanner;

public class BinaryTree {

    // Node class represents each element of the tree
    public static class Node {

        int data;       // Value stored in node
        Node left;      // Reference to left child
        Node right;     // Reference to right child

        // Constructor to create a new node
        public Node(int value) {
            this.data = value;
            this.left = null;   // Initially no left child
            this.right = null;  // Initially no right child
        }
    }

    // Root node of the tree
    private Node root;

    /*
     * This method starts tree creation.
     * It asks for root value and then calls
     * recursive populate method.
     */
    public void populate(Scanner scanner) {
        System.out.println("Enter the value for the root node value");
        int value = scanner.nextInt();

        // Create root node
        root = new Node(value);

        // Build rest of the tree
        populate(scanner, root);
    }

    /*
     * Recursive method to add children
     * for each node.
     */
    public void populate(Scanner scanner, Node node) {

        // ---------- LEFT CHILD ----------
        System.out.println("Do you want to add left child for " + node.data + "? (true/false)");
        boolean left = scanner.nextBoolean();

        if (left) {
            System.out.println("Enter the value for the left child of " + node.data);
            int value = scanner.nextInt();

            // Create left child
            node.left = new Node(value);

            // Recursively populate left subtree
            populate(scanner, node.left);
        }

        // ---------- RIGHT CHILD ----------
        System.out.println("Do you want to add right child for " + node.data + "? (true/false)");
        boolean right = scanner.nextBoolean();

        if (right) {
            System.out.println("Enter the value for the right child of " + node.data);
            int value = scanner.nextInt();

            // Create right child
            node.right = new Node(value);

            // Recursively populate right subtree
            populate(scanner, node.right);
        }
    }

    // Returns root of the tree
    public Node display() {
        return root;
    }

    /*
     * Displays tree using Preorder Traversal:
     * Root -> Left -> Right
     */
    public void display(Node node) {

        // Base condition
        if (node == null) {
            return;
        }

        // Print current node
        System.out.print(node.data + " ");

        // Visit left subtree
        display(node.left);

        // Visit right subtree
        display(node.right);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Create BinaryTree object
        BinaryTree binaryTree = new BinaryTree();

        // Build tree
        binaryTree.populate(scanner);

        // Display tree
        System.out.println("The tree elements are:");
        binaryTree.display(binaryTree.display());

    }
}
