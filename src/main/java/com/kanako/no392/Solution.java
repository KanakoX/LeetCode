package com.kanako.no392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        int tLen = t.length();
        int i = 0, j = 0;
        while (j < tLen && i < sLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }
}
