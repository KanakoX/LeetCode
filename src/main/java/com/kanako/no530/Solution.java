package com.kanako.no530;

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

    int lastVal = Integer.MAX_VALUE;
    int minVal = Integer.MAX_VALUE;

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minVal;
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        minVal = Math.min(minVal, Math.abs(root.val - lastVal));
        lastVal = root.val;
        inorder(root.right);
    }
}
