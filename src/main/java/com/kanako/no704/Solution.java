package com.kanako.no704;

public class Solution {
    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (nums[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        if (left == nums.length || nums[left] != target) return -1;
        return left;
    }
}
