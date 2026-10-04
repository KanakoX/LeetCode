package com.kanako.no2529;

public class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int start = lowerBound(nums, 0);
        if (start == n) return n;
        int end = lowerBound(nums, 1);
        return Math.max(n - end, start);
    }

    private int lowerBound(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return left;
    }
}
