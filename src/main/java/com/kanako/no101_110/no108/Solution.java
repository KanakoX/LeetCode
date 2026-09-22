package com.kanako.no101_110.no108;

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

        public TreeNode sortedArrayToBST(int[] nums) {
            return split(nums, 0, nums.length - 1);
        }

        private TreeNode split(int[] nums, int left, int right) {
            if (left > right) return null;
            int mid = left + ((right - left) >> 1);
            TreeNode root = new TreeNode(nums[mid]);
            root.left = split(nums, left, mid - 1);
            root.right = split(nums, mid + 1, right);
            return root;
        }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.sortedArrayToBST(new int[]{1,2,3,4,5,6,7,8,9});
    }
}
