package com.kanako.no1871_1880.no1872;

import java.util.Arrays;

public class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] pre = new int[n];
        pre[0] = stones[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] + stones[i];
        }
        int[] dp = new int[n];
        dp[n - 1] = pre[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            dp[i] = Math.max(pre[i] - dp[i + 1], dp[i + 1]);
        }
        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(dp));
        return dp[1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.stoneGameVIII(new int[]{7,-6,5,10,5,-2,-6}));
    }
}
