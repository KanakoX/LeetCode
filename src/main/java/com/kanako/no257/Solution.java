package com.kanako.no257;

import java.util.ArrayList;
import java.util.List;

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

    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null) return new ArrayList<>();
        List<String> res = new ArrayList<>();
        pushNode(root, "", res);
        return res;
    }

    private void pushNode(TreeNode root, String path, List<String> res) {
        if (root == null) {
            return;
        }
        path += root.val + "->";
        if (root.left == null && root.right == null) {
            res.add(path.substring(0, path.length() - 2));
        }
        pushNode(root.left, path, res);
        pushNode(root.right, path, res);
    }
}
