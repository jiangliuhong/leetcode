package com.jarome.leetcode.test1.summary;

import java.util.Stack;

public class SolutionDecodeString {

    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        String numStrTemp = "";
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String str = String.valueOf(c);
            // 判断是不是数字
            if (Character.isDigit(c)) {
                numStrTemp = numStrTemp + str;
                continue;
            } else {
                stack.push(numStrTemp);
                numStrTemp = "";
            }
            if ("]".equals(str)) {
                String base = "";
                while (true) {
                    String pop = stack.pop();
                    if ("[".equals(pop)) {
                        // 计算
                        // 按照题意，这个时候的栈顶元素一定是数字
                        Integer num = Integer.valueOf(stack.pop());
                        String newStr = "";
                        for (int j = 0; j < num; j++) {
                            newStr = newStr + base;
                        }
                        stack.push(newStr);
                        break;
                    }
                    base = pop + base;
                }
            } else {
                stack.push(str);
            }
        }
        String res = "";
        while (!stack.isEmpty()) {
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionDecodeString sd = new SolutionDecodeString();
        // String s = "2[abc]3[cd]ef";
        // String s = "3[a2[c]]";
        String s = "100[leetcode]";
        String res = sd.decodeString(s);
        System.out.println(res);
    }
}
