package com.kanako.no1_10.no3;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        boolean[] hasChar = new boolean[128];
        int left = 0;
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            while (hasChar[c]) {
                char leftC = s.charAt(left);
                hasChar[leftC] = false;
                left++;
            }
            hasChar[c] = true;
            maxLength = Math.max(maxLength, i - left + 1);
        }
        return maxLength;
    }
}
