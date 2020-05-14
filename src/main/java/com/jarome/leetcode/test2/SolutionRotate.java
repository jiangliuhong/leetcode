package com.jarome.leetcode.test2;

public class SolutionRotate {

    public void rotate(int[] nums, int k) {
        // 先针对数据长度求余，过滤无效的次数
        k = k % nums.length;
        Integer pre = nums[0];
        nums[0] = nums[nums.length - 1 - k];
        for (int j = 0; j < nums.length; j++) {
            int temp = nums[j];
            nums[j] = pre;
            pre = temp;
        }
    }


    public void rotate2(int[] nums, int k) {
        int len  = nums.length;
        k = k % len;
        int count = 0;         // 记录交换位置的次数，n个同学一共需要换n次
        for(int start = 0; count < len; start++) {
            int cur = start;       // 从0位置开始换位子
            int pre = nums[cur];
            do{
                int next = (cur + k) % len;
                int temp = nums[next];    // 来到角落...
                nums[next] = pre;
                pre = temp;
                cur = next;
                count++;
            }while(start != cur)  ;     // 循环暂停，回到起始位置，角落无人

        }
    }

}
