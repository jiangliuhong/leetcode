package com.jarome.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SolutionCenterLock {

    public static void main(String[] args) {
        String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
        // String[] deadends = {"0000"};
        String target = "0202";
        SolutionCenterLock sc = new SolutionCenterLock();
        int res = sc.openLock(deadends, target);
        System.out.println(res);
    }

    public int openLock(String[] deadends, String target) {
        Set<String> deadendSet = new HashSet<String>(Arrays.asList(deadends));
        String baseRec = "0000";
        Queue<String> queue = new LinkedList<String>();
        queue.offer(baseRec);
        Set<String> temp = new HashSet<String>();
        temp.add(baseRec);
        int num = -1;
        while (!queue.isEmpty()) {
            // 记录当前队列大小
            int thisQueueSize = queue.size();
            num++;
            // 处理这一行的数据
            for (int row = 0; row < thisQueueSize; row++) {
                String thisRec = queue.poll();
                if (deadendSet.contains(thisRec)) {
                    // 阻断，跳过
                    continue;
                }
                if (target.equals(thisRec)) {
                    return num;
                }
                // 8种可能 4个数字 加1 减1
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 2; j++) {
                        int ji = Integer.parseInt(String.valueOf(thisRec.charAt(i)));
                        if (j == 0) {
                            ji++;
                        } else {
                            ji--;
                        }
                        if (ji > 9) {
                            ji = 0;
                        } else if (ji < 0) {
                            ji = 9;
                        }
                        String newRec = thisRec.substring(0, i) + ji + thisRec.substring(i + 1);
                        // 该点已经操作过了。不进行操作
                        if (!temp.contains(newRec)) {
                            temp.add(newRec);
                            queue.offer(newRec);
                        }
                    }
                }
            }
        }
        return -1;
    }

}
