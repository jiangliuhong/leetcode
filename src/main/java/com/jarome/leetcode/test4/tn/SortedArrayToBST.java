package com.jarome.leetcode.test4.tn;

/**
 * 将有序数组转换为二叉搜索树
 */
public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        return sub(0, nums.length - 1, nums);
    }

    private TreeNode sub(int min, int max, int[] nums) {
        int seq = min + (max - min) / 2;
        TreeNode node = new TreeNode(nums[seq]);
        if (seq - min > 0) {
            node.left = sub(min, seq - 1, nums);
        }
        if (max - seq > 0) {
            node.right = sub(seq + 1, max, nums);
        }
        return node;
    }
}
