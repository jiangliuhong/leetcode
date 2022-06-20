package com.jarome.leetcode.algobase;

public class MaxArea {
    public int maxArea(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int a = Math.min(height[left], height[right]) * (right - left);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
            area = Math.max(a,area);
        }
        return area;
    }

    // 超时
    public int maxArea2(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            int maxRight = left;
            int maxArea = 0;
            for (int i = left; i <= right; i++) {
                int a = Math.min(height[left], height[i]) * (i - left);
                if (a >= maxArea) {
                    maxArea = a;
                    maxRight = i;
                }
            }
            if (area < maxArea) {
                right = maxRight;
                area = maxArea;
            }

            left++;

        }
        return area;
    }

    public static void main(String[] args) {
        MaxArea maxArea = new MaxArea();
        System.out.println(maxArea.maxArea(new int[] {2, 3, 4, 5, 18, 17, 6}));
        System.out.println(maxArea.maxArea(new int[] {2,1}));
        System.out.println(maxArea.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }
}
