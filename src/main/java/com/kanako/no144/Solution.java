package com.kanako.no144;

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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        orderTraversal(root, list);
        return list;
    }

    private void orderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        list.add(root.val);
        orderTraversal(root.left, list);
        orderTraversal(root.right, list);
    }
}
