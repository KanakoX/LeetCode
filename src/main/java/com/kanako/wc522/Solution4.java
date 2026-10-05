package com.kanako.wc522;

public class Solution4 {
    public int countGoodStrings(long n) {
        if(n == 1) return 2;
        if(n == 2) return 2;

        long[][] trans = {{1, 1},{1, 0}};
        long[][] mat = pow(trans, n - 2);

        long fn = (mat[0][0] * 2 % MOD + mat[0][1] * 2 % MOD) % MOD;
        return Math.toIntExact(fn);
    }

    final long MOD = 1_000_000_007;

    long[][] mul(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0] * b[0][0] % MOD + a[0][1] * b[1][0] % MOD) % MOD;
        res[0][1] = (a[0][0] * b[0][1] % MOD + a[0][1] * b[1][1] % MOD) % MOD;
        res[1][0] = (a[1][0] * b[0][0] % MOD + a[1][1] * b[1][0] % MOD) % MOD;
        res[1][1] = (a[1][0] * b[0][1] % MOD + a[1][1] * b[1][1] % MOD) % MOD;
        return res;
    }

    long[][] pow(long[][] mat, long p) {
        long[][] ans = {{1, 0},{0, 1}};
        while(p > 0) {
            if(p % 2 == 1) {
                ans = mul(ans, mat);
            }
            mat = mul(mat, mat);
            p /= 2;
        }
        return ans;
    }
}
