package com.kanako.no721_730.no729;

public class MyCalendar {

    private static final int MAX_T = 1_000_000_000;

    private static class Node {
        int max;
        int lazy;
        Node left;
        Node right;
    }

    private final Node root = new Node();

    public MyCalendar() {
    }

    /**
     * book 就三步（半开 [start,end) → 闭区间 [start, end-1]）：
     * 1. 查这段 max 覆盖
     * 2. >0 则重叠，false
     * 3. 否则整段 +1，true
     */
    public boolean book(int startTime, int endTime) {
        int L = startTime;
        int R = endTime - 1;
        if (queryMax(root, 0, MAX_T, L, R) > 0) {
            return false;
        }
        rangeAdd(root, 0, MAX_T, L, R, 1);
        return true;
    }

    /**
     * 查当前节点 [nl,nr] 与目标 [L,R] 相交部分的最大覆盖
     *
     * 1) 无交 → 0
     * 2) 当前段完全在目标里 → 返回 p.max（整块拿走）
     * 3) 部分相交 → 先 pushDown，再问左右，取 max
     */
    private int queryMax(Node p, int nl, int nr, int L, int R) {
        // 节点不存在 = 从没更新过 = 覆盖为 0
        if (p == null || nr < L || nl > R) {
            return 0;
        }
        // 整段被询问卷住，直接用已经维护好的 max
        if (L <= nl && nr <= R) {
            return p.max;
        }
        // 往下走前把懒标记推给儿子
        pushDown(p);
        int mid = nl + ((nr - nl) >>> 1);
        int leftMax = queryMax(p.left, nl, mid, L, R);
        int rightMax = queryMax(p.right, mid + 1, nr, L, R);
        return Math.max(leftMax, rightMax);
    }

    /** 把 p.lazy 传给左右儿子（没有儿子就先开出来） */
    private void pushDown(Node p) {
        if (p.lazy == 0) {
            return;
        }
        if (p.left == null) p.left = new Node();
        if (p.right == null) p.right = new Node();
        apply(p.left, p.lazy);
        apply(p.right, p.lazy);
        p.lazy = 0;
    }

    private void apply(Node p, int v) {
        p.max += v;
        p.lazy += v;
    }

    /**
     * 区间 [L,R] 每个点的覆盖 +v（729 里 v 就是 1）
     *
     * 1) 无交 → return
     * 2) 当前段完全在 [L,R] 里 → apply（max、lazy 都 +v），停
     * 3) 部分相交 → pushDown，该开的儿子 new 出来，递归左右，再 pullUp
     */
    private void rangeAdd(Node p, int nl, int nr, int L, int R, int v) {
        if (nr < L || nl > R) {
            return;
        }
        // 整段都要加：打在本节点上即可，不用下叶子
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
        // 用儿子的 max 更新自己
        int lm = p.left == null ? 0 : p.left.max;
        int rm = p.right == null ? 0 : p.right.max;
        p.max = Math.max(lm, rm);
    }
}
