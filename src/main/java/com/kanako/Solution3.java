package com.kanako;

public class Solution3 {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] sums = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int plus = nums[i];
            if (i % 2 != 0) plus = -plus;
            sums[i + 1] = sums[i] + plus;
        }
        return 0;
    }
}
