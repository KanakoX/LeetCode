package com.kanako.no637;

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

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        bfs(queue, result);
        return result;
    }

    private void bfs(Queue<TreeNode> currentQueue, List<Double> result) {
        if (currentQueue.isEmpty()) return;
        Queue<TreeNode> nextQueue = new LinkedList<>();
        double sum = 0.0;
        int n = currentQueue.size();
        while (!currentQueue.isEmpty()) {
            TreeNode node = currentQueue.poll();
            sum += node.val;
            if (node.left != null) {
                nextQueue.add(node.left);
            }
            if (node.right != null) {
                nextQueue.add(node.right);
            }
        }
        result.add(sum / n);
        bfs(nextQueue, result);
    }
}
