package com.prepInsta.javaDSA.dataStructures.linkedList;

public class CircularLinkedList {

    private Node head;
    private Node tail;

    // ---------- Node ----------
    private class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    // ---------- INSERT AT FIRST ----------
    public void insertFirst(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
            tail.next = head;
            return;
        }

        newNode.next = head;
        head = newNode;
        tail.next = head;
    }

    // ---------- INSERT AT LAST ----------
    public void insertLast(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            insertFirst(data);
            return;
        }

        tail.next = newNode;
        newNode.next = head;
        tail = newNode;
    }

    // ---------- INSERT AT POSITION ----------
    public void insertPosition(int data, int pos) {

        if (pos == 0) {
            insertFirst(data);
            return;
        }

        Node temp = head;
        for (int i = 1; i < pos; i++) {
            if (temp.next == head) {
                break; // reached end
            }
            temp = temp.next;
        }

        Node newNode = new Node(data);
        newNode.next = temp.next;
        temp.next = newNode;

        if (temp == tail) {
            tail = newNode;
        }
    }

    // ---------- DELETE FIRST ----------
    public void deleteFirst() {
        if (head == null) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        head = head.next;
        tail.next = head;
    }

    // ---------- DELETE LAST ----------
    public void deleteLast() {
        if (head == null) return;

        if (head == tail) {
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = head;
        tail = temp;
    }

    // ---------- DELETE BY VALUE ----------
    public void deleteValue(int val) {
        if (head == null) return;

        if (head.data == val) {
            deleteFirst();
            return;
        }

        Node prev = head;
        Node curr = head.next;

        while (curr != head) {
            if (curr.data == val) {
                prev.next = curr.next;
                if (curr == tail) {
                    tail = prev;
                }
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // ---------- DISPLAY ----------
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD");
    }

    // ---------- MAIN ----------
    public static void main(String[] args) {

        CircularLinkedList cll = new CircularLinkedList();

        cll.insertFirst(3);
        cll.insertFirst(2);
        cll.insertLast(4);
        cll.insertLast(6);
        cll.insertPosition(5, 3);

        cll.display();

        cll.deleteFirst();
        cll.display();

        cll.deleteLast();
        cll.display();

        cll.deleteValue(4);
        cll.display();
    }
}
