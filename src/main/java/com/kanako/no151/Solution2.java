package com.kanako.no151;

public class Solution2 {
    public String reverseWords(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int index = n - 1;
        StringBuilder result = new StringBuilder();
        while (index >= 0) {
            while (index >= 0 && chars[index] == ' ') index--;
            if (index < 0) break;
            int left = index;
            while (left >= 0 && chars[left] != ' ') left--;
            String word = s.substring(left + 1, index + 1);
            result.append(word).append(" ");
            index = left;
        }
        return result.toString().trim();
    }
}
