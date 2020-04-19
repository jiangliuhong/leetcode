package com.jarome.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class SolutionNumSquares {

    public int numSquares(int num) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(num);
        while(!queue.isEmpty()){
            Integer poll = queue.poll();
            boolean fullySquareNumber = isFullySquareNumber((poll));
            if(fullySquareNumber){

            }
        }
        return 0;
    }

    private boolean isFullySquareNumber(int num) {
        long start = 1, end = num / 2 + 1, res = 0;
        while (start <= end) {
            long mid = start + (end - start) / 2;
            res = mid * mid;
            if (res == num)
                return true;
            if (res > num)
                end = mid - 1;
            if (res < num)
                start = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) {

    }

}
