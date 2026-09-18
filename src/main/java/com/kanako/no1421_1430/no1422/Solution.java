package com.kanako.no1421_1430.no1422;

import java.util.Arrays;

public class Solution {
    public int maxScore(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int[] oneSums = new int[c.length + 1];
        int[] zeroSums = new int[c.length + 1];
        for (int i = 0; i < len; i++) {
            oneSums[i + 1] = oneSums[i] + (c[i] == '1' ? 1 : 0);
            zeroSums[i + 1] = zeroSums[i] + (c[i] == '0' ? 1 : 0);
        }

        System.out.println(Arrays.toString(oneSums));
        System.out.println(Arrays.toString(zeroSums));

        int maxScore = 0;
        for (int i = 1; i <= len; i++) {
            int score = zeroSums[i] + (oneSums[len] - oneSums[i]);
            maxScore = Math.max(maxScore, score);
        }
        return maxScore;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxScore("00"));
    }
}
