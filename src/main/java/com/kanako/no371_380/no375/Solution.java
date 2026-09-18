package com.kanako.no371_380.no375;

public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 1; i--) {
            for (int j = i + 1; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j; k++) {
                    int left  = (k == i) ? 0 : dp[i][k - 1];
                    int right = (k == j) ? 0 : dp[k + 1][j];
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(left, right));
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMoneyAmount(4));
    }
}
