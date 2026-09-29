package com.kanako.segtree;

/**
 * 线段树：区间加 + 区间求和（懒标记）
 *
 * rangeAdd(L, R, v) → a[L..R] 每个元素 +v
 * query(L, R)       → sum(a[L..R])
 */
public class SegmentTreeLazySum {

    private final int n;
    private final long[] sum;
    private final long[] lazy;

    public SegmentTreeLazySum(int[] a) {
        n = a.length;
        sum = new long[n * 4];
        lazy = new long[n * 4];
        build(1, 0, n - 1, a);
    }

    private void build(int p, int nl, int nr, int[] a) {
        if (nl == nr) {
            sum[p] = a[nl];
            return;
        }
        int mid = (nl + nr) >>> 1;
        build(p * 2, nl, mid, a);
        build(p * 2 + 1, mid + 1, nr, a);
        pullUp(p);
    }

    public void rangeAdd(int L, int R, long v) {
        rangeAdd(1, 0, n - 1, L, R, v);
    }

    public long query(int L, int R) {
        return query(1, 0, n - 1, L, R);
    }

    private void rangeAdd(int p, int nl, int nr, int L, int R, long v) {
        if (nr < L || nl > R) {
            return;
        }
        if (L <= nl && nr <= R) {
            apply(p, nl, nr, v);
            return;
        }
        pushDown(p, nl, nr);
        int mid = (nl + nr) >>> 1;
        rangeAdd(p * 2, nl, mid, L, R, v);
        rangeAdd(p * 2 + 1, mid + 1, nr, L, R, v);
        pullUp(p);
    }

    private long query(int p, int nl, int nr, int L, int R) {
        if (nr < L || nl > R) {
            return 0;
        }
        if (L <= nl && nr <= R) {
            return sum[p];
        }
        pushDown(p, nl, nr);
        int mid = (nl + nr) >>> 1;
        return query(p * 2, nl, mid, L, R)
                + query(p * 2 + 1, mid + 1, nr, L, R);
    }

    private void apply(int p, int nl, int nr, long v) {
        int len = nr - nl + 1;
        sum[p] += v * len;
        lazy[p] += v;
    }

    private void pushDown(int p, int nl, int nr) {
        if (lazy[p] == 0 || nl == nr) {
            return;
        }
        int mid = (nl + nr) >>> 1;
        apply(p * 2, nl, mid, lazy[p]);
        apply(p * 2 + 1, mid + 1, nr, lazy[p]);
        lazy[p] = 0;
    }

    private void pullUp(int p) {
        sum[p] = sum[p * 2] + sum[p * 2 + 1];
    }

    public static void main(String[] args) {
        // [1, 2, 3, 4]
        SegmentTreeLazySum st = new SegmentTreeLazySum(new int[]{1, 2, 3, 4});
        System.out.println(st.query(0, 3)); // 10

        st.rangeAdd(0, 2, 10); // → [11, 12, 13, 4]
        System.out.println(st.query(0, 3)); // 40
        System.out.println(st.query(0, 0)); // 11
        System.out.println(st.query(3, 3)); // 4
    }
}
