package com.jarome.leetcode.algobase;

import java.util.LinkedList;
import java.util.Queue;

import com.jarome.leetcode.test4.tn.TreeNode;

public class NodeIsSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (check(poll, subRoot)) {
                return true;
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        return false;
    }

    public boolean check(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            boolean l = check(root.left, subRoot.left);
            boolean r = check(root.right, subRoot.right);
            return l && r;
        }
        return false;
    }
}
