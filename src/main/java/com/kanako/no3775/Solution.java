package com.kanako.no3775;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int target = vowelCount(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (vowelCount(words[i]) == target) {
                words[i] = reverse(words[i]);
            }
        }
        return String.join(" ", words);
    }

    private String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int left = 0, right = chars.length - 1; left < right; left++, right--) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
        }
        return new String(chars);
    }

    private int vowelCount(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o' || word.charAt(i) == 'u') count++;
        }
        return count;
    }
}
