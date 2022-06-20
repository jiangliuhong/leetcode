package com.jarome.leetcode.algobase;

import java.util.Stack;

public class BackspaceCompare {
    public boolean backspaceCompare(String s, String t) {
        int is = 0;
        int it = 0;
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        while (is < s.length() || it < t.length()) {
            if (is < s.length()) {
                if (s.charAt(is) == '#') {
                    if (!stack1.empty()) {
                        stack1.pop();
                    }
                } else {
                    stack1.push(s.charAt(is));
                }
            }
            if (it < t.length()) {
                if (t.charAt(it) == '#') {
                    if (!stack2.empty()) {
                        stack2.pop();
                    }
                } else {
                    stack2.push(t.charAt(it));
                }
            }

            is++;
            it++;
        }
        while (!stack1.empty() && !stack2.empty() && stack1.peek() == stack2.peek()) {
            stack1.pop();
            stack2.pop();
        }
        return stack1.empty() && stack2.empty();
    }

    public static void main(String[] args) {
        BackspaceCompare b = new BackspaceCompare();
        System.out.println(b.backspaceCompare("bxj##tw", "bxo#j##tw"));
    }
}
