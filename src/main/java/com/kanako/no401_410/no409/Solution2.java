package com.kanako.no401_410.no409;

public class Solution2 {
    public int longestPalindrome(String s) {
        int[] chars = new int[26 * 2 + 6];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i) - 'A']++;
        }
        int count = 0;
        for (int charCount : chars) {
            count += charCount / 2 * 2;
            if (count % 2 == 0 && charCount % 2 == 1) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println('z' - 'A');
    }
}
