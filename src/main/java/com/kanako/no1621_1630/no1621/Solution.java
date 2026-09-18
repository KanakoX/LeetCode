package com.kanako.no1621_1630.no1621;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        // f[i][j]: 用前 i 个点，画了 j 段，且当前没有未结束的线段
        // g[i][j]: 用前 i 个点，画了 j 段，且最后一段还在延伸中（右端未定）
        long[][] f = new long[n + 1][k + 1];
        long[][] g = new long[n + 1][k + 1];
        f[1][0] = 1; // 只有 1 个点，0 段

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // 点 i 不参与任何线段：继承「到 i-1 时已画完」的方案
                f[i][j] = (f[i - 1][j] + g[i - 1][j]) % MOD;

                // 点 i 落在某段内部/右端：继续延伸上一段
                g[i][j] = g[i - 1][j];
                if (j > 0) {
                    // 在 i-1 处新开一段，或把「正在画」的那一段多盖一个点
                    // 新开：上一状态已收束，从 i-1→i 开始第 j 段
                    // 延伸且刚变成 j 段：上一段也在画，到 i 时算完成第 j 段的延伸
                    g[i][j] = (g[i][j] + f[i - 1][j - 1] + g[i - 1][j - 1]) % MOD;
                }
            }
        }
        return (int) ((f[n][k] + g[n][k]) % MOD);
    }
}
