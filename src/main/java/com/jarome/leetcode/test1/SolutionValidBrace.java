package com.jarome.leetcode.test1;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SolutionValidBrace {

    Map<String, String> right = new HashMap<>();

    public SolutionValidBrace() {
        right.put("(", ")");
        right.put(")", "(");
        right.put("{", "}");
        right.put("}", "{");
        right.put("[", "]");
        right.put("]", "[");
    }

    public boolean isValid(String s) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            String str = String.valueOf(s.charAt(i));
            if (!stack.isEmpty()) {
                String peek = stack.peek();
                String peekRight = right.get(peek);
                if (str.equals(peekRight)) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(str);

        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        SolutionValidBrace svb = new SolutionValidBrace();
         System.out.println(svb.isValid("(]"));
         System.out.println(svb.isValid("([)]"));
        System.out.println(svb.isValid("{[]}"));
    }
}
