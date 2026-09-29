package com.kanako.no2911_2920.no2913;

import java.util.Arrays;
import java.util.List;

/**
 * 线段树解法：
 * 叶子 i = 左端点 i 的 d(i, 当前r)
 * 支持区间 +1，维护 Σd 与 Σd²
 */
public class Solution {

    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        SegmentTree st = new SegmentTree(n);

        // last[x] = 值 x 上一次出现的下标，没有则为 -1
        int[] last = new int[101];
        Arrays.fill(last, -1);

        int ans = 0;
        for (int r = 0; r < n; r++) {
            int x = nums.get(r);
            // 左端点在 (last[x], r] 上，x 是新出现的 → d 整体 +1
            st.rangeAdd(last[x] + 1, r, 1);
            // 累加「以 r 为右端点」的所有 d(l,r)²
            ans += (int) st.querySumSq(0, r);
            last[x] = r;
        }
        return ans;
    }

    /** 维护 sum(d) 与 sum(d²)，支持区间加 */
    private static class SegmentTree {
        final int n;
        final long[] sum;    // 区间内 d 之和
        final long[] sumSq;  // 区间内 d² 之和
        final long[] lazy;   // 懒标记：整段待加的增量

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

        private void rangeAdd(int p, int nl, int nr, int L, int R, int v) {
            if (L <= nl && nr <= R) {
                apply(p, nl, nr, v);
                return;
            }
            pushDown(p, nl, nr);
            int mid = (nl + nr) >>> 1;
            if (L <= mid) rangeAdd(p * 2, nl, mid, L, R, v);
            if (R > mid) rangeAdd(p * 2 + 1, mid + 1, nr, L, R, v);
            pullUp(p);
        }

        private long querySumSq(int p, int nl, int nr, int L, int R) {
            if (nr < L || nl > R) return 0;
            if (L <= nl && nr <= R) return sumSq[p];
            pushDown(p, nl, nr);
            int mid = (nl + nr) >>> 1;
            return querySumSq(p * 2, nl, mid, L, R)
                    + querySumSq(p * 2 + 1, mid + 1, nr, L, R);
        }

        /** 当前节点整段每个 d 都 +v：(d+v)² = d² + 2vd + v² */
        private void apply(int p, int nl, int nr, long v) {
            int len = nr - nl + 1;
            sumSq[p] += 2 * v * sum[p] + v * v * len;
            sum[p] += v * len;
            lazy[p] += v;
        }

        private void pushDown(int p, int nl, int nr) {
            if (lazy[p] == 0 || nl == nr) return;
            int mid = (nl + nr) >>> 1;
            apply(p * 2, nl, mid, lazy[p]);
            apply(p * 2 + 1, mid + 1, nr, lazy[p]);
            lazy[p] = 0;
        }

        private void pullUp(int p) {
            sum[p] = sum[p * 2] + sum[p * 2 + 1];
            sumSq[p] = sumSq[p * 2] + sumSq[p * 2 + 1];
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.sumCounts(List.of(1, 2, 1))); // 15
        System.out.println(s.sumCounts(List.of(2, 2)));    // 3
    }
}
