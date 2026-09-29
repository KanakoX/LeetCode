package com.kanako.no3471_3480.no3479;


public class Solution2 {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        SegmentTree st = new SegmentTree(baskets);
        int unplaced = fruits.length;
        for (int f : fruits) {
            if (st.tree[1] >= f) {
                unplaced--;
                st.findAndUpdate(1, 0, st.n - 1, f);
            }
        }
        return unplaced;
    }

    private static class SegmentTree {
        final int n;
        final int[] tree;

        SegmentTree(int[] baskets) {
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

        int findAndUpdate(int p, int nl, int nr, int val) {
            if (nl == nr) {
                tree[p] = 0;
                return 0;
            }
            int mid = nl + ((nr - nl) >>> 1);
            if (tree[p * 2] >= val) {
                int newLeft = findAndUpdate(p * 2, nl, mid, val);
                tree[p] = Math.max(newLeft, tree[p * 2 + 1]);
            } else {
                int newRight = findAndUpdate(p * 2 + 1, mid + 1, nr, val);
                tree[p] = Math.max(tree[p * 2], newRight);
            }
            return tree[p];
        }
    }
}
