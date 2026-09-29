package com.kanako.no671_680.no671;

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

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) return -1;
        return secondMinimumValue(root, root.val) == root.val ? -1 : secondMinimumValue(root, root.val);
    }

    private int secondMinimumValue(TreeNode root, int rootVal) {
        if (root.left == null) return root.val;
        int left, right;
        if (root.left.val == root.right.val) {
            left = secondMinimumValue(root.left, rootVal);
            right = secondMinimumValue(root.right, rootVal);
        } else if (root.left.val < root.right.val) {
            left = secondMinimumValue(root.left, rootVal);
            right = root.right.val;
        } else {
            left = root.left.val;
            right = secondMinimumValue(root.right, rootVal);
        }
        int min = Math.min(left, right);
        if (min == root.val) return Math.max(left, right);
        return min;
    }
}
