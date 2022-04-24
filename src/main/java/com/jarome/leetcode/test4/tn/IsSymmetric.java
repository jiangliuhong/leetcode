package com.jarome.leetcode.test4.tn;

import java.util.LinkedList;
import java.util.Queue;

/**
 * IsSymmetric <br/>
 * 验证对称二叉树
 * 
 * @author jiangliuhong
 * @date 2021/3/22 下午3:46
 * @version 1.0.0
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> qL = new LinkedList<>(), qR = new LinkedList<>();
        qL.offer(root);
        qR.offer(root);
        while (!qL.isEmpty()) {
            TreeNode left = qL.poll();
            TreeNode right = qR.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || (left.val != right.val)) {
                return false;
            }
            qL.offer(left.left);
            qL.offer(left.right);
            qR.offer(right.right);
            qR.offer(right.left);
        }
        return true;
    }

    public boolean isSymmetric2(TreeNode root) {
        return calculate(root.left, root.right);
    }

    private boolean calculate(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return calculate(left.left, right.right) && calculate(left.right, right.left);
    }
}
