package com.kanako.no931_940.no931;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[] dp = matrix[n - 1].clone();
//        System.out.println(Arrays.toString(dp));
        for (int i = n - 2; i >= 0; i--) {
            int[] next = new int[n];
            for (int j = 0; j < n; j++) {
                next[j] = matrix[i][j] + Math.min(Math.min(dp[j], (j - 1 >= 0 ? dp[j - 1] : Integer.MAX_VALUE)), (j + 1 < n ? dp[j + 1] : Integer.MAX_VALUE));
            }
            dp = next;
//            System.out.println(Arrays.toString(dp));
        }
        int min = Integer.MAX_VALUE;
        for (int j : dp) {
            if (j < min) min = j;
        }
        return min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minFallingPathSum(new int[][]{{2,1,3}, {6,5,4}, {7,8,9}}));
    }
}
