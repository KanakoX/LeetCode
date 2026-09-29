package com.kanako.no731_740.no731;

public class MyCalendarTwo {
    final int MAX_T = 1_000_000_000;

    private class Node {
        int max;
        Node left, right;
        int lazy;
    }

    private final Node root = new Node();

    public MyCalendarTwo() {

    }

    public boolean book(int startTime, int endTime) {
        int L = startTime;
        int R = endTime - 1;
        if (queryMax(root, 0, MAX_T, L, R) >= 2) {
            return false;
        }
        rangeAdd(root, 0, MAX_T, L, R, 1);
        return true;
    }

    private void rangeAdd(Node p, int nl, int nr, int L, int R, int v) {
        if (R < nl || L > nr) return;
        if (L <= nl && nr <= R) {
            apply(p, v);
            return;
        }
        pushDown(p);
        int mid = nl + ((nr - nl) >>> 1);
        if (L <= mid) {
            if (p.left == null) p.left = new Node();
            rangeAdd(p.left, nl, mid, L, R, v);
        }
        if (R > mid) {
            if (p.right == null) p.right = new Node();
            rangeAdd(p.right, mid + 1, nr, L, R, v);
        }
        int lm = p.left == null ? 0 : p.left.max;
        int rm = p.right == null ? 0 : p.right.max;
        p.max = Math.max(lm, rm);
    }

    private int queryMax(Node p, int nl, int nr, int L, int R) {
        if (p == null || R < nl || L > nr) return 0;
        if (L <= nl && nr <= R) return p.max;
        pushDown(p);
        int mid = nl + ((nr - nl) >>> 1);
        int leftMax = queryMax(p.left, nl, mid, L, R);
        int rightMax = queryMax(p.right, mid + 1, nr, L, R);
        return Math.max(leftMax, rightMax);
    }

    private void pushDown(Node p) {
        if (p.lazy == 0) return;
        if (p.left == null) p.left = new Node();
        if (p.right == null) p.right = new Node();
        apply(p.left, p.lazy);
        apply(p.right, p.lazy);
        p.lazy = 0;
    }

    private void apply(Node p, int v) {
        p.lazy += v;
        p.max += v;
    }
}
