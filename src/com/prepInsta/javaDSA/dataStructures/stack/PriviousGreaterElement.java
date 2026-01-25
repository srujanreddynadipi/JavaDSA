package com.prepInsta.javaDSA.dataStructures.stack;

import static com.prepInsta.javaDSA.dataStructures.stack.temp.previousGreaterElement;

class temp{
    static  void previousGreaterElement(int[] arr , int size){
        for(int i= 0 ; i < size ; i++){
            boolean flag = false ;
            for(int j = i-1 ; j >= 0 ; j--){
                if(arr[j]>arr[i]){
                    System.out.print(arr[j]+" ");
                    flag = true ;
                    break;
                }
                }
            if(flag == false){
                System.out.print( "- ");
            }
        }
    }


}

public class PriviousGreaterElement {
    public static void main(String[] args)
    {
        int[] arr = {30, 50, 20, 15, 25};
        int size = arr.length;
        previousGreaterElement(arr, size);

    }
}
