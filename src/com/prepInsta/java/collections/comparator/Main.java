package com.prepInsta.java.collections.comparator;
import java.util.ArrayList;
import java.util.Collections;
import com.prepInsta.java.collections.comparator.PhoneDirectory;

public class Main{
    public static void main(String[] args){
        ArrayList<PhoneDirectory> pd = new ArrayList<>();
        pd.add( new PhoneDirectory("Apple", "987654"));
        pd.add( new PhoneDirectory("Zebra", "89374"));
        pd.add( new PhoneDirectory("Cat", "867554"));
        pd.add( new PhoneDirectory("Mango", "53342"));
        pd.add( new PhoneDirectory("Dog", "6535437"));
        pd.add( new PhoneDirectory("Bat", "97898"));

        Collections.sort(pd);

        for(PhoneDirectory obj : pd)
        {
            System.out.println(obj.getContactName()+ " " + obj.getContactNumber());
        }

    }
}

