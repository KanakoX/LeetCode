package com.kanako.no1231_1240.no1234;

public class Solution {
    public int balancedString(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int fours = n / 4;
        int[] charCnt = new int[4];
        for (int i = 0; i < n; i++) {
            charCnt[format(chars[i])]++;
        }
        if (charCnt[0] == fours && charCnt[1] == fours && charCnt[2] == fours && charCnt[3] == fours) return 0;
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        for (int i = 0; i < n; i++) {
            char curC = chars[i];
            charCnt[format(curC)]--;
            while (charCnt[0] < fours && charCnt[1] < fours && charCnt[2] < fours && charCnt[3] < fours) {
                minLen = Math.min(minLen, i - left + 1);
                charCnt[format(chars[left++])]++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    private int format(char c) {
        int res = 0;
        switch (c) {
            case 'W' -> res = 1;
            case 'E' -> res = 2;
            case 'R' -> res = 3;
        }
        return res;
    }
}
