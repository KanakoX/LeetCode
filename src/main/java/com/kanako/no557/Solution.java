package com.kanako.no557;

public class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ' || i == n - 1) {
                int right = i == n - 1 ? i : i - 1;
                while (left < right) {
                    char temp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = temp;
                    left++;
                    right--;
                }
                left = i + 1;
            }
        }
        return new String(chars);
    }

    private void reverse(char[] c, int left, int right) {
        while (left < right) {
            char temp = c[left];
            c[left] = c[right];
            c[right] = temp;
            left++;
            right--;
        }
    }
}
