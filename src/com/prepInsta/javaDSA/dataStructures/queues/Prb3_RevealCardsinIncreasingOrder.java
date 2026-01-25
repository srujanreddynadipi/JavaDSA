package com.prepInsta.javaDSA.dataStructures.queues;
import  java.util.*;

public class Prb3_RevealCardsinIncreasingOrder {

    public static int[] deckRevealedIncreasing(int[] deck) {
        // Step 1: Sort the deck
        Arrays.sort(deck);
        Deque<Integer> deque = new ArrayDeque<>();
        // Step 2: Reverse simulation
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!deque.isEmpty()) {
                deque.addFirst(deque.removeLast());
            }
            deque.addFirst(deck[i]);
        }
        // Step 3: Convert deque to array
        int[] result = new int[deck.length];
        int index = 0;
        for (int num : deque) {
            result[index++] = num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {17,13,11,2,3,5,7};
        int[] answer = deckRevealedIncreasing(arr);
        for(int num : answer){
            System.out.print(num+" ");
        }
        //2 13 3 11 5 17 7 
    }
}
