package com.kanako.no571_580.no572;

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

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) return false;
        return isSameTree(root, subRoot)
                || isSubtree(root.left, subRoot)
                || isSubtree(root.right, subRoot);
    }

    private boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if (root != null && subRoot != null) {
            if (root.val != subRoot.val) return false;
            return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        }
        return root == null && subRoot == null;
    }
}
