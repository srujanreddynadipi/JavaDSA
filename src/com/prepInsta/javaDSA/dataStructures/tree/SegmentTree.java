package com.prepInsta.javaDSA.dataStructures.tree;

public class SegmentTree {
    class Node{
        int start;
        int end;
        int data;
        Node left;
        Node right;

        public Node(int start , int end){
            this.start = start ;
            this.end = end ;
            this.left = null ;
            this.right = null ;
        }
    }

    private Node root ;

    public SegmentTree(int[] nums) {
        root = construct(nums , 0 , nums.length-1);
    }

    private Node construct(int[] nums , int start , int end){
        if(start > end){
            return null ;
        }

        if(start == end){
            Node leaf = new Node(start , end);
            leaf.data = nums[start];
            return leaf ;
        }

        Node node = new Node(start , end);

        int mid = start + (end - start) / 2 ;

        node.left = construct(nums , start , mid);
        node.right = construct(nums , mid+1 , end);
        node.data = node.left.data + node.right.data ;
        return node ;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 9, 11};
        SegmentTree st = new SegmentTree(nums);
        st.display();
    }


}
