package com.jarome.leetcode.test1;

import java.util.Stack;

public class SolutionEvalRPN {

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            // 根据题目，tokens里只能是整数或者运算符
            String token = tokens[i];
            if (isOperator(token)) {
                // 做一个容错判断
                if (stack.size() >= 2) {
                    // 第一次出栈获取的是第二个数
                    Integer num2 = stack.pop();
                    Integer num1 = stack.pop();
                    switch (token) {
                        case "+":
                            stack.push(num1 + num2);
                            break;
                        case "-":
                            stack.push(num1 - num2);
                            break;
                        case "*":
                            stack.push(num1 * num2);
                            break;
                        case "/":
                            stack.push(num1 / num2);
                            break;
                    }
                }
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        int res = 0;
        if (!stack.isEmpty()) {
            res = stack.pop();
        }
        return res;
    }

    private boolean isOperator(String str) {
        return "+".equals(str) || "-".equals(str) || "*".equals(str) || "/".equals(str);
    }

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        SolutionEvalRPN sr = new SolutionEvalRPN();
        int i = sr.evalRPN(tokens);
        System.out.println(i);
    }
}
