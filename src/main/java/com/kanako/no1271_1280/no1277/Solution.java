package com.kanako.no1271_1280.no1277;

public class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] dp = new int[n];
        int num = 0;
        for (int[] ints : matrix) {
            int prev = 0;
            for (int j = 0; j < n; j++) {
                int top = dp[j];
                if (ints[j] == 1) {
                    int left = j - 1 >= 0 ? dp[j - 1] : 0;
                    dp[j] = Math.min(Math.min(top, left), prev) + 1;
                    num += dp[j];
                } else dp[j] = 0;
                prev = top;
            }
        }
        return num;
    }
}
