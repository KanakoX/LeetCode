package com.kanako.no111_120.no111;

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

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        if (root.left != null && root.right != null) {
            return Math.min(left, right) + 1;
        } else if (root.left != null) {
            return left + 1;
        } else if (root.right != null) {
            return right + 1;
        }
        return 1;
    }
}
