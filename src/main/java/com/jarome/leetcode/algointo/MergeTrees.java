package com.jarome.leetcode.algointo;

import com.jarome.leetcode.test4.tn.TreeNode;

public class MergeTrees {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        } else if (root1 == null) {
            return root2;
        } else if (root2 == null) {
            return root1;
        } else {
            int val = root1.val + root2.val;
            TreeNode l1 = root1.left != null ? root1.left : null;
            TreeNode l2 = root2.left != null ? root2.left : null;
            TreeNode r1 = root1.right != null ? root1.right : null;
            TreeNode r2 = root2.right != null ? root2.right : null;
            return new TreeNode(val, mergeTrees(l1, l2), mergeTrees(r1, r2));
        }
    }

}
