package com.kanako.no2721_2730.no2730;

public class Solution {
    public int longestSemiRepetitiveSubstring(String s) {
        int n = s.length();
        if (n <= 1) {
            return n;
        }
        int ans = 1;
        int left = 0;
        int same = 0;
        for (int right = 1; right < n; right++) {
            if (s.charAt(right) == s.charAt(right - 1)) {
                same++;
            }
            while (same > 1) {
                if (s.charAt(left) == s.charAt(left + 1)) {
                    same--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
