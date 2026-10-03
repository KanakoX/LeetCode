package com.kanako.no1750;

public class Solution {
    public int minimumLength(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            if (chars[left] == chars[right]) {
                char curChar = chars[left];
                while (left < right && chars[left] == curChar) left++;
                while (left < right && chars[right] == curChar) right--;
            } else break;
        }
        return right - left + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumLength("cabaabac"));
    }
}
