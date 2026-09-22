package com.kanako.no91_100.no94;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    private TreeNode buildTree(Integer[] arr) {
        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        int index = 1;
        while (!nodeQueue.isEmpty() && index < arr.length) {
            TreeNode currentNode = nodeQueue.poll();
            if (arr[index] != null) {
                currentNode.left = new TreeNode(arr[index]);
                nodeQueue.add(currentNode.left);
            }
            index++;
            if (index < arr.length && arr[index] != null) {
                currentNode.right = new TreeNode(arr[index]);
                nodeQueue.add(currentNode.right);
            }
            index++;
        }
        return root;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root != null) {
            inorder(root.left, list);
            list.add(root.val);
            inorder(root.right, list);
        }
    }

    public static void main(String[] args) {
        Integer[] data = new Integer[]{1, null, 2, 3};
        Solution solution = new Solution();
        TreeNode root = solution.buildTree(data);
        System.out.println(solution.inorderTraversal(root));
    }
}
