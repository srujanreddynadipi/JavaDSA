package com.prepInsta.java.inheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        //String[] s = new String{"dog" , "cat " , "dog " , "cat"};
        String[] arr = {"dog", "cat", "dog", "cat"};
        for (String s : arr) {
            //s.makeSound();
            System.out.println(s);
        }
        dog.makeSound();

    }
}
