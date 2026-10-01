package com.kanako.no3081_3090.no3090;

public class Solution {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        int[] charCnt = new int[26];
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            char curC = s.charAt(i);
            charCnt[curC - 'a']++;
            while (charCnt[curC - 'a'] > 2) {
                char leftC = s.charAt(left++);
                charCnt[leftC - 'a']--;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
