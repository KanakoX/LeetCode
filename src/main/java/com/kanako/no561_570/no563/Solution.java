package com.kanako.no561_570.no563;

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

    int sum = 0;

    public int findTilt(TreeNode root) {
        sumNode(root);
        return sum;
    }

    private int sumNode(TreeNode root) {
        if (root == null) return 0;
        int leftSum = sumNode(root.left);
        int rightSum = sumNode(root.right);
        sum += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;
    }
}
