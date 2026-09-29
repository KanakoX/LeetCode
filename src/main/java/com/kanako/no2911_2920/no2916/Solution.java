package com.kanako.no2911_2920.no2916;

import java.util.Arrays;

public class Solution {
    private static final int MOD = 1_000_000_007;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        SegmentTree st = new SegmentTree(n);

        int[] last = new int[100_001];
        Arrays.fill(last, -1);

        long ans = 0;
        for (int r = 0; r < n; r++) {
            int x = nums[r];
            st.rangeAdd(last[x] + 1, r, 1);
            ans = (ans + st.querySumSq(0, r)) % MOD;
            last[x] = r;
        }
        return (int) ans;
    }

    private static class SegmentTree {
        final int n;
        final long[] sum;
        final long[] sumSq;
        final long[] lazy;

        SegmentTree(int n) {
            this.n = n;
            sum = new long[n * 4];
            sumSq = new long[n * 4];
            lazy = new long[n * 4];
        }

        void rangeAdd(int L, int R, int v) {
            if (L > R) return;
            rangeAdd(1, 0, n - 1, L, R, v);
        }

        long querySumSq(int L, int R) {
            return querySumSq(1, 0, n - 1, L, R);
        }

        private void rangeAdd(int p, int nl, int nr, int L, int R, long v) {
            if (nr < L || nl > R) return;
            if (L <= nl && nr <= R) {
                apply(p, nl, nr, v);
                return;
            }
            pushDown(p, nl, nr);
            int mid = nl + ((nr - nl) >>> 1);
            if (L <= mid) rangeAdd(p * 2, nl, mid, L, R, v);
            if (R > mid) rangeAdd(p * 2 + 1, mid + 1, nr, L, R, v);
            pullUp(p);
        }

        private long querySumSq(int p, int nl, int nr, int L, int R) {
            if (nr < L || nl > R) return 0;
            if (L <= nl && nr <= R) return sumSq[p];
            pushDown(p, nl, nr);
            int mid = nl + ((nr - nl) >>> 1);
            return (querySumSq(p * 2, nl, mid, L, R) + querySumSq(p * 2 + 1, mid + 1, nr, L, R)) % MOD;
        }

        private void apply(int p, int nl, int nr, long v) {
            int len = nr - nl + 1;
            // (d+v)^2 = d^2 + 2vd + v^2
            sumSq[p] = (sumSq[p] + 2 * v % MOD * sum[p] % MOD + v * v % MOD * len % MOD) % MOD;
            sum[p] = (sum[p] + v * len % MOD) % MOD;
            lazy[p] = (lazy[p] + v) % MOD;
        }

        private void pushDown(int p, int nl, int nr) {
            if (lazy[p] == 0 || nl == nr) return;
            int mid = nl + ((nr - nl) >>> 1);
            apply(p * 2, nl, mid, lazy[p]);
            apply(p * 2 + 1, mid + 1, nr, lazy[p]);
            lazy[p] = 0;
        }

        private void pullUp(int p) {
            sum[p] = (sum[p * 2] + sum[p * 2 + 1]) % MOD;
            sumSq[p] = (sumSq[p * 2] + sumSq[p * 2 + 1]) % MOD;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumCounts(new int[]{1, 2, 1})); // 15
        System.out.println(s.sumCounts(new int[]{2, 2}));    // 3
    }
}
