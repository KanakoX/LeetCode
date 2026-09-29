package com.kanako.no301_310.no307;

public class NumArray {
    final int[] tree;
    final int n;

    public NumArray(int[] nums) {
        n = nums.length;
        tree = new int[n << 2];
        build(1, 0, n - 1, nums);
    }

    private void build(int p, int nl, int nr, int[] nums) {
        if (nl == nr) {
            tree[p] = nums[nl];
            return;
        }
        int mid = nl + ((nr - nl) >>> 1);
        build(p * 2, nl, mid, nums);
        build(p * 2 + 1, mid + 1, nr, nums);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    public void update(int index, int val) {
        update(1, 0, n - 1, index, val);
    }

    public int sumRange(int left, int right) {
        return sumRange(1, 0, n - 1, left, right);
    }

    private void update(int p, int nl, int nr, int index, int val) {
        if (nl == nr) {
            tree[p] = val;
            return;
        }
        int mid = nl + ((nr - nl) >>> 1);
        if (index <= mid) update(p * 2, nl, mid, index, val);
        else update(p * 2 + 1, mid + 1, nr, index, val);
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    private int sumRange(int p, int nl, int nr, int L, int R) {
        if (nr < L || nl > R) return 0;
        if (L <= nl && nr <= R) return tree[p];
        int mid = nl + ((nr - nl) >>> 1);
        return sumRange(p * 2, nl, mid, L, R) + sumRange(p * 2 + 1, mid + 1, nr, L, R);
    }
}
