package com.kanako.no3471_3480.no3479;

public class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree st = new SegmentTree(baskets);
        int unplaced = 0;
        for (int fruit : fruits) {
            int index = st.findFirst(fruit);
            if (index == -1) {
                unplaced++;
            } else {
                st.update(index, 0);
            }
        }
        return unplaced;
    }

    private static class SegmentTree {
        final int n;
        final int[] tree;

        public SegmentTree(int[] baskets) {
            n = baskets.length;
            tree = new int[n << 2];
            build(1, 0, n - 1, baskets);
        }

        private void build(int p, int nl, int nr, int[] baskets) {
            if (nl == nr) {
                tree[p] = baskets[nl];
                return;
            }
            int mid = nl + ((nr - nl) >>> 1);
            build(p * 2, nl, mid, baskets);
            build(p * 2 + 1, mid + 1, nr, baskets);
            tree[p] = Math.max(tree[p * 2], tree[p * 2 + 1]);
        }

        public void update(int index, int val) {
            update(1, 0, n - 1, index, val);
        }

        private void update(int p, int nl, int nr, int index, int val) {
            if (nl == nr) {
                tree[p] = val;
                return;
            }
            int mid = nl + ((nr - nl) >>> 1);
            if (index <= mid) update(p * 2, nl, mid, index, val);
            else update(p * 2 + 1, mid + 1, nr, index, val);
            tree[p] = Math.max(tree[p * 2], tree[p * 2 + 1]);
        }

        public int findFirst(int target) {
            return findFirst(1, 0, n - 1, target);
        }

        private int findFirst(int p, int nl, int nr, int target) {
            if (tree[p] < target) {
                return -1;
            }
            if (nl == nr) {
                return nl;
            }
            int mid = nl + ((nr - nl) >>> 1);
            if (tree[p * 2] >= target) {
                return findFirst(p * 2, nl, mid, target);
            }
            return findFirst(p * 2 + 1, mid + 1, nr, target);
        }
    }
}
