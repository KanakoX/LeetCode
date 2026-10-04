package com.kanako.no678;

public class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int leftCntMin = 0, leftCntMax = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == '(') {
                leftCntMin++;
                leftCntMax++;
            } else if (chars[i] == ')') {
                leftCntMin = Math.max(leftCntMin - 1, 0);
                leftCntMax--;
                if (leftCntMax < 0) return false;
            } else if (chars[i] == '*') {
                leftCntMin = Math.max(leftCntMin - 1, 0);
                leftCntMax++;
            }
        }
        return leftCntMin == 0;
    }
}
