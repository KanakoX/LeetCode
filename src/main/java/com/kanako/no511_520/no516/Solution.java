package com.kanako.no511_520.no516;

import java.util.Arrays;

public class Solution {
    public int longestPalindromeSubseq(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[][] memo = new int[len][len];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(chars, 0, len - 1, memo);
    }

    private int dfs(char[] nums, int start, int end, int[][] memo) {
        if (start == end) return 1;
        if (start > end) return 0;
        if (memo[start][end] != -1) return memo[start][end];
        if (nums[start] == nums[end]) {
            return memo[start][end] = dfs(nums, start + 1, end - 1, memo) + 2;
        }
        return memo[start][end] = Math.max(dfs(nums, start + 1, end, memo), dfs(nums, start, end - 1, memo));
    }
}
