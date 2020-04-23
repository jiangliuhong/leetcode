package com.jarome.leetcode;

import java.util.ArrayList;
import java.util.List;

public class MinStack {

    List<Integer> list = new ArrayList<>();

    int min = Integer.MAX_VALUE;

    public MinStack() {

    }

    public void push(int x) {
        list.add(x);
        min = Math.min(min, x);
    }

    public void pop() {
        if (list.size() >= 1) {
            Integer remove = list.remove(list.size() - 1);
            if (remove <= min) {
                // 移除的小于等于最小值，重新遍历寻找
                min = Integer.MAX_VALUE;
                for (Integer integer : list) {
                    min = Math.min(min, integer);
                }
            }
        }
    }

    public int top() {
        if (list.size() < 1) {
            throw new RuntimeException("is empty");
        }
        return list.get(list.size() - 1);
    }

    public int getMin() {
        if (list.size() < 1) {
            throw new RuntimeException("is empty");
        }
        return min;
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        int min = minStack.getMin();
        System.out.println(min);
        minStack.pop();
        int top = minStack.top();
        System.out.println(top);
        int min1 = minStack.getMin();
        System.out.println(min1);
    }

}
