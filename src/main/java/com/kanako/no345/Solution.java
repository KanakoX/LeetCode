package com.kanako.no345;

public class Solution {
    public String reverseVowels(String s) {
        int n = s.length();
        int left = 0, right = n - 1;
        char[] chars = s.toCharArray();
        while (left < right) {
            while (left < right && !isVowel(chars[left])) left++;
            while (left < right && !isVowel(chars[right])) right--;
            if (left >= right) break;
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
        return new String(chars);
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
