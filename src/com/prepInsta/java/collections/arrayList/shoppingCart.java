package com.prepInsta.java.collections.arrayList;

import java.util.ArrayList;
public class shoppingCart{
    public int[] array = new int[10];
    public ArrayList shoppingCart = new ArrayList<>();

    public void addItem(String item){
        shoppingCart.add(item);
    }

    public void printList(){
        System.out.println("There are " + shoppingCart.size()+ "items in your cart");
        for(int i =0;i< shoppingCart.size();i++){
            System.out.println("Item no " + (i+1) + "is : "+shoppingCart.get(i));
        }
    }

    public void modifyCart(int position,String newItem){
        shoppingCart.set(position , newItem);
        System.out.println("Shopping Item" + (position + 1) + "has been updated");
    }

    public void removeItem(int position){
        String itemName = (String) shoppingCart.get(position);
        shoppingCart.remove(position);
    }

    public String searchItem(String searchItem){
        int position = shoppingCart.indexOf(searchItem);
        if(position >=0){
            return (String) shoppingCart.get(position);
        }
        else
            return null;
    }
}
