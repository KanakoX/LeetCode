package com.kanako.no917;

public class Solution {
    public String reverseOnlyLetters(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int left = 0, right = n - 1;
        while (left < right) {
            while (left < right && !Character.isLetter(chars[left])) left++;
            while (left < right && !Character.isLetter(chars[right])) right--;
            if (left >= right) break;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }
}
