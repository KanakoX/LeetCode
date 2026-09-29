package com.kanako.no1471_1480.no1480;

public class Solution2 {

    public int[] runningSum(int[] nums) {
        int n = nums.length;
        SegmentTree segmentTree = new SegmentTree(nums);
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = segmentTree.query(0, i);
        }
        return result;
    }

    private static class SegmentTree {
        private final int[] tree;
        private final int n;

        public SegmentTree(int[] values) {
            this.n = values.length;
            this.tree = new int[n * 4];
            build(1, 0, n - 1, values);
        }

        private void build(int p, int nl, int nr, int[] values) {
            if (nl == nr) {
                tree[p] = values[nl];
                return;
            }
            int mid = nl + ((nr - nl) >>> 1);
            build(p * 2, nl, mid, values);
            build(p * 2 + 1, mid + 1, nr, values);
            tree[p] = tree[p * 2] + tree[p * 2 + 1];
        }

        public int query(int L, int R) {
            return query(1, 0, n - 1, L, R);
        }

        private int query(int p, int nl, int nr, int L, int R) {
            if (nr < L || nl > R) return 0;
            if (nl >= L && nr <= R) return tree[p];
            int mid = nl + ((nr - nl) >>> 1);
            return query(p * 2, nl, mid, L, R) + query(p * 2 + 1, mid + 1, nr, L, R);
        }
    }
}
