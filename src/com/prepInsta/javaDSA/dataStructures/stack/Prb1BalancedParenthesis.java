package com.prepInsta.javaDSA.dataStructures.stack;
import  java.util.Stack;

public class Prb1BalancedParenthesis {
    static boolean isValid(String str) {
        int n = str.length();
        if (n % 2 == 1)
            return false;
        Stack<Character> s = new Stack<Character>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                s.push(str.charAt(i));
            } else {
                if (s.isEmpty()) {
                    return false;
                }
                char topChar = s.pop();
                if (ch == ')' && topChar != '(')
                    return false;
                if (ch == '}' && topChar != '{')
                    return false;
                if (ch == ']' && topChar != '[')
                    return false;
            }
        }
        return s.isEmpty();
    }
    public static void main(String[] args) {
        String s = "((({{[[]]}})))";
        System.out.println(isValid(s));
    }
}
