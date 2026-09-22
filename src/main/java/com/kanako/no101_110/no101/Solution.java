package com.kanako.no101_110.no101;

public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) return false;
            return (isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left));
        }
        return p == null && q == null;
    }
}
