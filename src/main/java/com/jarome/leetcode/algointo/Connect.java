package com.jarome.leetcode.algointo;

import java.util.LinkedList;
import java.util.Queue;

public class Connect {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int count = 1;
        while (queue.peek() != null) {
            Node pre = null;
            int tempCount = 0;
            for (int i = 0; i < count; i++) {
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                    tempCount++;
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                    tempCount++;
                }
                pre = poll;
            }
            count = tempCount;
        }
        return root;
    }
}
