package com.kanako.no2000;

public class Solution {
    public String reversePrefix(String word, char ch) {
        char[] chars = word.toCharArray();
        int index = word.indexOf(ch);
        for (int left = 0, right = index; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return new String(chars);
    }
}
