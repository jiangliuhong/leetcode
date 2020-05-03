package com.jarome.leetcode.test1.summary;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class SolutionCanVisitAllRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> queue = new LinkedList<>();
        // 房间进入情况缓存
        Set<Integer> cache = new HashSet<>();
        // 进入 0号房间
        List<Integer> zeroKeys = rooms.get(0);
        cache.add(0);
        for (Integer zeroKey : zeroKeys) {
            queue.offer(zeroKey);
        }
        while (!queue.isEmpty()) {
            Integer key = queue.poll();
            if (cache.contains(key)) {
                continue;
            }
            // 进入房间
            List<Integer> keys = rooms.get(key);
            cache.add(key);
            if (keys != null) {
                for (Integer keyRoom : keys) {
                    queue.offer(keyRoom);
                }
            }
        }
        return cache.size() == rooms.size();
    }

}
