package com.kanako.no2697;

public class Solution {
    public String makeSmallestPalindrome(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        for (int left = 0, right = n - 1; left < right; left++, right--) {
            if (chars[left] == chars[right]) continue;
            if (chars[left] < chars[right]) chars[right] = chars[left];
            else chars[left] = chars[right];
        }
        return new String(chars);
    }
}
