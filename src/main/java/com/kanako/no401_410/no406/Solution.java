package com.kanako.no401_410.no406;

import java.util.Arrays;

public class Solution {
    int n;
    int[] space;

    public int[][] reconstructQueue(int[][] people) {
        n = people.length;
        space = new int[n << 2];
        build(1, 0, n - 1);

        Arrays.sort(people, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);

        int[][] ans = new int[n][2];
        for (int[] one : people) {
            int pos = findIndex(1, 0, n - 1, one[1] + 1);
            update(1, 0, n - 1, pos);
            ans[pos] = one;
        }
        return ans;
    }

    private void build(int p, int nl, int nr) {
        if (nl == nr) {
            space[p] = 1;
            return;
        }
        int mid = nl + ((nr - nl) >>> 1);
        build(p * 2, nl, mid);
        build(p * 2 + 1, mid + 1, nr);
        space[p] = space[p * 2] + space[p * 2 + 1];
    }

    private int findIndex(int p, int nl, int nr, int need) {
        if (nl == nr) return nl;
        int mid = nl + ((nr - nl) >>> 1);
        if (space[p * 2] >= need) return findIndex(p * 2, nl, mid, need);
        return findIndex(p * 2 + 1, mid + 1, nr, need - space[p * 2]);
    }

    private void update(int p, int nl, int nr, int pos) {
        if (nl == nr) {
            space[p] = 0;
            return;
        }
        int mid = nl + ((nr - nl) >>> 1);
        if (pos <= mid) update(p * 2, nl, mid, pos);
        else update(p * 2 + 1, mid + 1, nr, pos);
        space[p] = space[p * 2] + space[p * 2 + 1];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.deepToString(
                s.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}
