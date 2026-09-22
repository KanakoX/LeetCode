package com.kanako.no501;

import java.util.ArrayList;
import java.util.Arrays;
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

    private final List<Integer> list = new ArrayList<>();
    private int maxCount = 0;
    private int currentValue = 0, currentCount = 0;

    public int[] findMode(TreeNode root) {
        inorder(root);
        return list.stream().mapToInt(i -> i).toArray();
    }

    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        handleVal(root.val);
        inorder(root.right);
    }

    private void handleVal(int value) {
        if (currentValue == value) {
            currentCount++;
        } else {
            currentValue = value;
            currentCount = 1;
        }
        if (currentCount == maxCount) {
            list.add(value);
        } else if (currentCount > maxCount) {
            list.clear();
            list.add(value);
            maxCount = currentCount;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = solution.new TreeNode(1);
        root.right = solution.new TreeNode(2);
        System.out.println(Arrays.toString(solution.findMode(root)));;
    }
}
