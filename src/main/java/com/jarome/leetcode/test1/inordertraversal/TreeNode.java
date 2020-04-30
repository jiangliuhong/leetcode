package com.jarome.leetcode.test1.inordertraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        // 中序遍历：左子树 -> 根节点 -> 右子树
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode peek = stack.peek();
            if (peek.left != null) {
                stack.push(peek.left);
                peek.left = null;
                continue;
            }
            stack.pop();
            res.add(peek.val);
            if (peek.right != null) {
                stack.push(peek.right);
            }
        }
        return res;
    }
}