package com.kanako.no111_120.no115;

import java.util.Arrays;

public class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dfs(m - 1, n - 1, s.toCharArray(), t.toCharArray(), memo);
    }

    private int dfs(int m, int n, char[] s, char[] t, int[][] memo) {
        if (m < n) return 0;
        if (n < 0) return 1;
        if (memo[m][n] != -1) return memo[m][n];
        int res = dfs(m - 1, n, s, t, memo);
        if (s[m] == t[n]) res += dfs(m - 1, n - 1, s, t, memo);
        return memo[m][n] = res;
    }
}
