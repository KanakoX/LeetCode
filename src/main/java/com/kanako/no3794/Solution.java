package com.kanako.no3794;

public class Solution {
    public String reversePrefix(String s, int k) {
        char[] chars = s.toCharArray();
        for (int left = 0, right = k - 1; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return new String(chars);
    }
}
