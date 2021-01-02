package com.jarome.leetcode.test4.tn;

public class IsValidBST {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if (min != null && min >= root.val) {
            return false;
        }
        if (max != null && max <= root.val) {
            return false;
        }
        if (!isValidBST(root.left, min, root.val)) {
            return false;
        }
        if (!isValidBST(root.right, root.val, max)) {
            return false;
        }
        return true;
    }
}
