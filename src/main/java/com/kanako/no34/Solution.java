package com.kanako.no34;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start = lowerBound(nums, target);
        if (start == nums.length || nums[start] != target) return new int[]{-1, -1};
        int end = lowerBound(nums, target + 1) - 1;
        return new int[]{start, end};
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >>> 1);
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}

// 0 1 2 3 8 8 8 8 8 9