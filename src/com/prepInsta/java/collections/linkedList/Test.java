package com.prepInsta.java.collections.linkedList;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Test {
    public static void main(String[] args) {
        LinkedList<String> englishAlpha = new LinkedList<String>();

        addInAscOrd(englishAlpha,"Apple");
        addInAscOrd(englishAlpha,"Bat");
        addInAscOrd(englishAlpha,"Cat");
        addInAscOrd(englishAlpha,"Dog");
        addInAscOrd(englishAlpha,"Elephant");
        addInAscOrd(englishAlpha,"Fox");
        addInAscOrd(englishAlpha,"Bag");

        updateWord(englishAlpha,"Bag" , "bull");
        printList(englishAlpha);

    }

    private  static  void printList(LinkedList<String> linkedList) {
       Iterator<String> alpha = linkedList.iterator();
       while(alpha.hasNext()){
           System.out.println(alpha.next());
       }
    }

    private static boolean addInAscOrd(LinkedList<String> linkedList, String newWord){
        ListIterator<String>  stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()){
            int compare = stringListIterator.next().compareTo(newWord);
            if(compare == 0 ){
                System.out.println("word already exist");
                return  false ;
            }else if (compare > 0){
                stringListIterator.previous();
                stringListIterator.add(newWord);
                return  true;
            } else if (compare < 0) {

            }
        }
        stringListIterator.add(newWord);
        return true;
    }

    private  static boolean updateWord(LinkedList<String> linkedList , String oldWord , String newWord){
        ListIterator<String> it = linkedList.listIterator();
        while (it.hasNext()){
            if(it.next().equals(oldWord)){
                it.set(newWord);
                return true;
            }
        }
        return false;

    } private  static boolean removeWord(LinkedList<String> linkedList , String word ){
        ListIterator<String> it = linkedList.listIterator();
        while (it.hasNext()){
            if(it.next().equals(word)){
                it.remove();
                return true;
            }
        }
        return false;
    }


}
