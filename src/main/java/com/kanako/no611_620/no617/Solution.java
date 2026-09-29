package com.kanako.no611_620.no617;

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

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null) return root2;
        merge(root1, root2);
        return root1;
    }

    private void merge(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return;
        root1.val += root2.val;
        if (root1.left != null) {
            merge(root1.left, root2.left);
        } else root1.left = root2.left;
        if (root1.right != null) {
            merge(root1.right, root2.right);
        } else root1.right = root2.right;
    }
}
