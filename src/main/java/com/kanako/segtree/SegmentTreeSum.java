package com.kanako.segtree;

/**
 * 线段树最小模板：单点修改 + 区间求和
 *
 * 用法对照：
 *   new SegmentTreeSum(a)  → 用数组 a 建树
 *   update(i, val)         → 把下标 i 改成 val
 *   query(L, R)            → 求 a[L] + ... + a[R]（闭区间）
 *
 * 节点编号从 1 开始：左儿子 2*p，右儿子 2*p+1
 */
public class SegmentTreeSum {

    private final int n;
    /** tree[p] = 节点 p 所管区间的元素之和 */
    private final long[] tree;

    public SegmentTreeSum(int[] a) {
        this.n = a.length;
        // 最坏大约 4n 个节点够用
        this.tree = new long[n * 4];
        build(1, 0, n - 1, a);
    }

    /**
     * 建树：当前节点 p 负责闭区间 [nl, nr]
     *
     * 叶子：区间长度 1，sum = a[nl]
     * 非叶：先建左右儿子，再 sum = 左 + 右
     */
    private void build(int p, int nl, int nr, int[] a) {
        if (nl == nr) {
            tree[p] = a[nl];
            return;
        }
        int mid = (nl + nr) >>> 1;
        build(p * 2, nl, mid, a);         // 左： [nl, mid]
        build(p * 2 + 1, mid + 1, nr, a);  // 右： [mid+1, nr]
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    /** 对外：把下标 i 改成 val */
    public void update(int i, int val) {
        update(1, 0, n - 1, i, val);
    }

    /**
     * 单点修改：在节点 p（管 [nl,nr]）的范围内，把下标 i 改成 val
     *
     * 思路：一路走到叶子 i，改完后沿路往上用「左+右」重算
     */
    private void update(int p, int nl, int nr, int i, int val) {
        if (nl == nr) {
            tree[p] = val;
            return;
        }
        int mid = (nl + nr) >>> 1;
        if (i <= mid) {
            update(p * 2, nl, mid, i, val);
        } else {
            update(p * 2 + 1, mid + 1, nr, i, val);
        }
        tree[p] = tree[p * 2] + tree[p * 2 + 1];
    }

    /** 对外：查询闭区间 [L, R] 的和 */
    public long query(int L, int R) {
        return query(1, 0, n - 1, L, R);
    }

    /**
     * 区间查询：在节点 p（管 [nl,nr]）里，求与目标 [L,R] 相交部分的和
     *
     * 三种情况：
     * 1) 当前区间与 [L,R] 无交 → 贡献 0
     * 2) 当前区间完全被 [L,R] 包含 → 直接返回 tree[p]（整块拿走）
     * 3) 部分相交 → 左右儿子答案相加
     */
    private long query(int p, int nl, int nr, int L, int R) {
        if (nr < L || nl > R) {
            return 0;
        }
        if (L <= nl && nr <= R) {
            return tree[p];
        }
        int mid = (nl + nr) >>> 1;
        return query(p * 2, nl, mid, L, R)
                + query(p * 2 + 1, mid + 1, nr, L, R);
    }

    // ---------- 跑一下感受 ----------
    public static void main(String[] args) {
        // 下标: 0  1  2  3
        int[] a = {1, 3, 5, 7};
        SegmentTreeSum st = new SegmentTreeSum(a);

        // [0,3] = 1+3+5+7 = 16
        System.out.println("query(0,3) = " + st.query(0, 3));
        // [1,2] = 3+5 = 8
        System.out.println("query(1,2) = " + st.query(1, 2));

        // a[1] 改成 10：数组变为 [1,10,5,7]
        st.update(1, 10);
        System.out.println("update(1,10) 后 query(0,3) = " + st.query(0, 3)); // 23
        System.out.println("update(1,10) 后 query(1,2) = " + st.query(1, 2)); // 15
    }
}
