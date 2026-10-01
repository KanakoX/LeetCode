package com.kanako.no641_650.no643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        int index = 0;
        while (index < nums.length) {
            currentSum += nums[index++];
            int left = index - k;
            if (left < 0) continue;
            maxSum = Math.max(maxSum, currentSum);
            currentSum -= nums[left];
        }
        return (double) maxSum / k;
    }
}
