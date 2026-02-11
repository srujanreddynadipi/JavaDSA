package com.prepInsta.javaDSA.dataStructures.tree;

public class AVLTreeDebug {

    public class Node {
        private int value;
        private Node left;
        private Node right;
        private int height;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private Node root;

    public AVLTreeDebug() {

    }

    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public void insert(int value) {
        System.out.println("\n========================================");
        System.out.println("INSERTING VALUE: " + value);
        System.out.println("========================================");
        root = insert(value, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            node = new Node(value);
            System.out.println("Created new node with value: " + value);
            return node;
        }

        if (value < node.value) {
            System.out.println(value + " < " + node.value + " → Going LEFT");
            node.left = insert(value, node.left);
        }

        if (value > node.value) {
            System.out.println(value + " > " + node.value + " → Going RIGHT");
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        System.out.println("Updated height of node " + node.value + " to: " + node.height);

        return rotate(node);
    }

    /**
     * MAIN ROTATION LOGIC - This checks if tree is unbalanced and performs appropriate rotation
     *
     * Balance Factor = height(left subtree) - height(right subtree)
     * - If BF > 1: Left Heavy (left subtree is too tall)
     * - If BF < -1: Right Heavy (right subtree is too tall)
     * - If -1 <= BF <= 1: Balanced (no rotation needed)
     */
    private Node rotate(Node node) {
        int leftHeight = height(node.left);
        int rightHeight = height(node.right);
        int balanceFactor = leftHeight - rightHeight;

        System.out.println("\n--- Checking balance at node " + node.value + " ---");
        System.out.println("Left height: " + leftHeight);
        System.out.println("Right height: " + rightHeight);
        System.out.println("Balance Factor: " + balanceFactor);

        // LEFT HEAVY CASES (balance factor > 1)
        if (balanceFactor > 1) {
            System.out.println("⚠️  LEFT HEAVY detected at node " + node.value);

            int leftChildBalance = height(node.left.left) - height(node.left.right);
            System.out.println("Left child (" + node.left.value + ") balance: " + leftChildBalance);

            // LEFT-LEFT Case
            if(leftChildBalance > 0) {
                System.out.println("📍 LEFT-LEFT Case detected!");
                System.out.println("Performing RIGHT rotation on node " + node.value);
                visualizeBeforeRotation(node, "RIGHT");
                Node result = rightRotate(node);
                visualizeAfterRotation(result, "RIGHT");
                return result;
            }

            // LEFT-RIGHT Case
            if(leftChildBalance < 0) {
                System.out.println("📍 LEFT-RIGHT Case detected!");
                System.out.println("Step 1: Performing LEFT rotation on left child " + node.left.value);
                visualizeBeforeRotation(node.left, "LEFT");
                node.left = leftRotate(node.left);
                visualizeAfterRotation(node.left, "LEFT");

                System.out.println("Step 2: Performing RIGHT rotation on node " + node.value);
                visualizeBeforeRotation(node, "RIGHT");
                Node result = rightRotate(node);
                visualizeAfterRotation(result, "RIGHT");
                return result;
            }
        }

        // RIGHT HEAVY CASES (balance factor < -1)
        if (balanceFactor < -1) {
            System.out.println("⚠️  RIGHT HEAVY detected at node " + node.value);

            int rightChildBalance = height(node.right.left) - height(node.right.right);
            System.out.println("Right child (" + node.right.value + ") balance: " + rightChildBalance);

            // RIGHT-RIGHT Case
            if(rightChildBalance < 0) {
                System.out.println("📍 RIGHT-RIGHT Case detected!");
                System.out.println("Performing LEFT rotation on node " + node.value);
                visualizeBeforeRotation(node, "LEFT");
                Node result = leftRotate(node);
                visualizeAfterRotation(result, "LEFT");
                return result;
            }

            // RIGHT-LEFT Case
            if(rightChildBalance > 0) {
                System.out.println("📍 RIGHT-LEFT Case detected!");
                System.out.println("Step 1: Performing RIGHT rotation on right child " + node.right.value);
                visualizeBeforeRotation(node.right, "RIGHT");
                node.right = rightRotate(node.right);
                visualizeAfterRotation(node.right, "RIGHT");

                System.out.println("Step 2: Performing LEFT rotation on node " + node.value);
                visualizeBeforeRotation(node, "LEFT");
                Node result = leftRotate(node);
                visualizeAfterRotation(result, "LEFT");
                return result;
            }
        }

        System.out.println("✓ Node " + node.value + " is balanced. No rotation needed.");
        return node;
    }

    /**
     * RIGHT ROTATION
     *
     * Before:              After:
     *      p                  c
     *     / \                / \
     *    c   T3             T1  p
     *   / \                    / \
     *  T1  T2                 T2  T3
     *
     * Steps:
     * 1. Save the left child (c) - this will become the new root
     * 2. Save c's right child (T2) - this will move to p's left
     * 3. Make p the right child of c
     * 4. Make T2 the left child of p
     * 5. Update heights
     */
    public Node rightRotate(Node p) {
        System.out.println("\n🔄 Executing RIGHT ROTATION:");
        System.out.println("Parent node (p): " + p.value);

        Node c = p.left;  // Child node that will become new root
        System.out.println("Child node (c): " + c.value);

        Node t = c.right; // Temporary subtree that needs to be moved
        System.out.println("Moving subtree (t): " + (t == null ? "null" : t.value));

        // Perform rotation
        c.right = p;
        p.left = t;
        System.out.println("Rotation complete: " + c.value + " is now the root");

        // Update heights (must update p first, then c)
        p.height = Math.max(height(p.left), height(p.right)) + 1;
        c.height = Math.max(height(c.left), height(c.right)) + 1;

        System.out.println("New height of " + p.value + ": " + p.height);
        System.out.println("New height of " + c.value + ": " + c.height);

        return c; // Return new root of this subtree
    }

    /**
     * LEFT ROTATION
     *
     * Before:              After:
     *    c                    p
     *   / \                  / \
     *  T1  p                c   T3
     *     / \              / \
     *    T2  T3           T1  T2
     *
     * Steps:
     * 1. Save the right child (p) - this will become the new root
     * 2. Save p's left child (T2) - this will move to c's right
     * 3. Make c the left child of p
     * 4. Make T2 the right child of c
     * 5. Update heights
     */
    public Node leftRotate(Node c) {
        System.out.println("\n🔄 Executing LEFT ROTATION:");
        System.out.println("Child node (c): " + c.value);

        Node p = c.right; // Parent node that will become new root
        System.out.println("Parent node (p): " + p.value);

        Node t = p.left;  // Temporary subtree that needs to be moved
        System.out.println("Moving subtree (t): " + (t == null ? "null" : t.value));

        // Perform rotation
        p.left = c;
        c.right = t;
        System.out.println("Rotation complete: " + p.value + " is now the root");

        // Update heights (must update c first, then p)
        c.height = Math.max(height(c.left), height(c.right)) + 1;
        p.height = Math.max(height(p.left), height(p.right)) + 1;

        System.out.println("New height of " + c.value + ": " + c.height);
        System.out.println("New height of " + p.value + ": " + p.height);

        return p; // Return new root of this subtree
    }

    private void visualizeBeforeRotation(Node node, String rotationType) {
        System.out.println("\n📊 BEFORE " + rotationType + " ROTATION:");
        printTreeStructure(node, "", true);
    }

    private void visualizeAfterRotation(Node node, String rotationType) {
        System.out.println("\n📊 AFTER " + rotationType + " ROTATION:");
        printTreeStructure(node, "", true);
    }

    private void printTreeStructure(Node node, String prefix, boolean isTail) {
        if (node == null) {
            return;
        }

        System.out.println(prefix + (isTail ? "└── " : "├── ") + node.value + " (h=" + node.height + ")");

        if (node.left != null || node.right != null) {
            if (node.left != null) {
                printTreeStructure(node.left, prefix + (isTail ? "    " : "│   "), node.right == null);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + "├── null");
            }

            if (node.right != null) {
                printTreeStructure(node.right, prefix + (isTail ? "    " : "│   "), true);
            } else {
                System.out.println(prefix + (isTail ? "    " : "│   ") + "└── null");
            }
        }
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            this.insert(nums[i]);
        }
    }

    public void display() {
        System.out.println("\n========================================");
        System.out.println("FINAL TREE STRUCTURE:");
        System.out.println("========================================");
        display(this.root, "Root Node: ");
    }

    private void display(Node node, String details) {
        if (node == null) {
            return;
        }
        System.out.println(details + node.value);
        display(node.left, "Left child of " + node.value + " : ");
        display(node.right, "Right child of " + node.value + " : ");
    }

    public boolean balanced() {
        return balanced(root);
    }

    private boolean balanced(Node node) {
        if (node == null) {
            return true;
        }
        return Math.abs(height(node.left) - height(node.right)) <= 1 && balanced(node.left) && balanced(node.right);
    }

    public static void main(String[] args) {
        AVLTreeDebug avl = new AVLTreeDebug();

        System.out.println("╔═══════════════════════════════════════════════════╗");
        System.out.println("║     AVL TREE ROTATION DEBUG DEMONSTRATION         ║");
        System.out.println("╚═══════════════════════════════════════════════════╝");

        int[] nums = {10, 20, 30, 40, 50, 25};
        System.out.println("\nInserting values: " + java.util.Arrays.toString(nums));

        avl.populate(nums);
        avl.display();

        System.out.println("\n========================================");
        System.out.println("Is the tree balanced? " + avl.balanced());
        System.out.println("========================================");
    }
}