package com.kanako.no2871_2880.no2875;

public class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int left = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        for (int i = 0; i < n * 2; i++) {
            int curNum = nums[i % n];
            sum += curNum;
            while (sum > target % total) {
                int leftNum = nums[left++ % n];
                sum -= leftNum;
            }
            if (sum == target % total) minLen = Math.min(minLen, i - left + 1);
        }
        return minLen == Integer.MAX_VALUE ? -1 : minLen + target / total * n;
    }
}

// 2,4,6,8,2,4,6,8
