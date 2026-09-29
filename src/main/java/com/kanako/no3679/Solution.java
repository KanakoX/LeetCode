package com.kanako.no3679;

public class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int[] typeCnt = new int[100001];
        int n = arrivals.length;
        if (n == 1) return 0;
        int[] hasDrop = new int[n];
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int type = arrivals[i];
            typeCnt[type]++;
            if (typeCnt[type] > m) {
                typeCnt[type]--;
                cnt++;
                hasDrop[i] = 1;
            }

            int left = i - w + 1;
            if (left < 0) continue;

            if (hasDrop[left] != 1) {
                typeCnt[arrivals[left]]--;
            }
        }
        return cnt;
    }
}
