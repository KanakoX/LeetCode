package com.kanako.no1451_1460.no1456;

public class Solution {
    public int maxVowels(String s, int k) {
        int index = 0;
        int count = 0;
        int ans = 0;
        while (index < s.length()) {
            char c = s.charAt(index++);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') count++;
            int left = index - k;
            if (left < 0) continue;
            ans = Math.max(ans, count);
            if (ans == k) break;
            char out = s.charAt(left);
            if (out == 'a' || out == 'e' || out == 'i' || out == 'o' || c == 'u') count--;
        }
        return ans;
    }
}
