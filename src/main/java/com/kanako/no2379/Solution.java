package com.kanako.no2379;

public class Solution {
    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int index = 0;
        int currentCnt = 0;
        int minCnt = Integer.MAX_VALUE;
        while (index < n) {
            int left = index - k + 1;
            if (blocks.charAt(index++) == 'W') currentCnt++;
            if (left < 0) continue;
            minCnt = Math.min(minCnt, currentCnt);
            if (blocks.charAt(left) == 'W') currentCnt--;
        }
        return minCnt;
    }
}
