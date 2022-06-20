package com.jarome.leetcode.algobase;

import java.util.LinkedList;
import java.util.Queue;

import com.jarome.leetcode.algointo.Node;

public class ConnectNode {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        int count = 1;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int tempCount = 0;
            Node pre = null;
            for (int i = 0; i < count; i++) {
                Node poll = queue.poll();
                if (pre != null) {
                    pre.next = poll;
                }
                pre = poll;
                if (poll.left != null) {
                    tempCount++;
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    tempCount++;
                    queue.offer(poll.right);
                }
            }
            count = tempCount;
        }
        return root;
    }
}
