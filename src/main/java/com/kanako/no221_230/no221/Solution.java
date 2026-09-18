package com.kanako.no221_230.no221;

public class Solution {
    public int maximalSquare(char[][] matrix) {
        int n = matrix[0].length;
        int[] dp = new int[n];
        int max = 0;
        for (char[] chars : matrix) {
            int prev = 0;
            for (int j = 0; j < n; j++) {
                int top = dp[j];
                if (chars[j] == '1') {
                    int left = j > 0 ? dp[j - 1] : 0;
                    dp[j] = Math.min(Math.min(top, left), prev) + 1;
                } else {
                    dp[j] = 0;
                }
                prev = top;
                max = Math.max(max, dp[j]);
            }
        }
        return max * max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximalSquare(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}));
    }
}
