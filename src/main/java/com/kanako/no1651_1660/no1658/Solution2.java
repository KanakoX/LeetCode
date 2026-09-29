package com.kanako.no1651_1660.no1658;

import java.util.Arrays;

public class Solution2 {
    public int minOperations(int[] nums, int x) {
        int minStep = Integer.MAX_VALUE;
        int sum = Arrays.stream(nums).sum();
        if (sum < x) return -1;
        int end = 0, leftSum = 0, rightSum = sum;
        int n = nums.length;
        for (int start = -1; start < n; start++) {
            if (start != -1) leftSum += nums[start];
            while (end < n && rightSum + leftSum > x) {
                rightSum -= nums[end];
                end++;
            }
            if (leftSum + rightSum == x) {
                minStep = Math.min(minStep, n - end + start + 1);
            }
        }
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }
}
