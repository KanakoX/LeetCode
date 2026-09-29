package com.kanako.no111_120.no112;

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return check(root, targetSum, 0);
    }

    private boolean check(TreeNode root, int targetSum, int sum) {
        if (root == null) return targetSum == sum;
        sum += root.val;
        if (root.left == null && root.right == null) return targetSum == sum;
        if (root.left == null) return check(root.right, targetSum, sum);
        if (root.right == null) return check(root.left, targetSum, sum);
        return check(root.left, targetSum, sum) || check(root.right, targetSum, sum);
    }
}
