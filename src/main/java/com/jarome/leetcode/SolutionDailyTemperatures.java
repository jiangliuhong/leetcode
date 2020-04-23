package com.jarome.leetcode;

import java.util.Stack;

public class SolutionDailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int[] res = new int[T.length];
        // 温度的栈
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < T.length; i++) {
            if (i == 0) {
                stack.push(i);
                continue;
            }
            while (!stack.isEmpty()) {
                int peek = stack.peek();
                if (T[i] > T[peek]) {
                    int pop = stack.pop();
                    int day = i - pop;
                    res[pop] = day;
                } else {
                    break;
                }
            }
            stack.push(i);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        SolutionDailyTemperatures st = new SolutionDailyTemperatures();
        int[] ints = st.dailyTemperatures(temperatures);
        String res = "";
        for (int i = 0; i < ints.length; i++) {
            res += ints[i];
        }
        System.out.println(res);
    }
}
