package com.kanako.no3521_3530.no3524;

public class Solution {
    public long[] resultArray(int[] nums, int k) {
        int n = nums.length;
        long[] result = new long[k];

        long[][] dp = new long[n][k];

        int first = nums[0] % k;
        dp[0][first] = 1;
        result[first] = 1;

        for (int i = 1; i < n; i++) {
            int val = nums[i] % k;

            dp[i][val] += 1;

            for (int p = 0; p < k; p++) {
                if (dp[i - 1][p] == 0) {
                    continue;
                }
                int nr = (int) ((p * (long) val) % k);
                dp[i][nr] += dp[i - 1][p];
            }

            for (int r = 0; r < k; r++) {
                result[r] += dp[i][r];
            }
        }
        return result;
    }
}
