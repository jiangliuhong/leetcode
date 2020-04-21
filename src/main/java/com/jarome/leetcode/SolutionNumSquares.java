package com.jarome.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionNumSquares {

    public int numSquares(int num) {
        List<Integer> sqrtList = new ArrayList<>();
        // 先枚举出所有
        for (int i = 1; i <= num; i++) {
            int sqrt = i * i;
            if (sqrt == num) {
                return 1;
            } else if (sqrt > num) {
                // 已经超过当前数字了就不需要在执行了
                break;
            }
            sqrtList.add(sqrt);
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(num);
        int count = 0;
        while (!queue.isEmpty()) {
            count = count + 1;
            // 避免循环加入队列
            Set<Integer> temp = new HashSet<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (Integer sqrt : sqrtList) {
                    if (poll.equals(sqrt)) {
                        return count;
                    } else if (poll < sqrt) {
                        break;
                    } else {
                        int nextVal = poll - sqrt;
                        if (!temp.contains(nextVal)) {
                            queue.offer(nextVal);
                            temp.add(nextVal);
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SolutionNumSquares sns = new SolutionNumSquares();
        System.out.println(sns.numSquares(12));
    }

}
