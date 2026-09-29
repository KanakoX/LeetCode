package com.kanako.no541_550.no543;

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

    int maxDistance = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        longestNode(root);
        return maxDistance;
    }

    private int longestNode(TreeNode root) {
        if (root == null) return 0;
        int left = longestNode(root.left);
        int right = longestNode(root.right);
        maxDistance = Math.max(maxDistance, left + right);
        return Math.max(left, right) + 1;
    }
}
