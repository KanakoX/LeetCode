package com.kanako.no2061_2070.no2062;

public class Solution {
    public int countVowelSubstrings(String word) {
        int n = word.length();
        char[] chars = word.toCharArray();
        char[] charCnt = new char[26];
        int ans = 0;
        int left = 0;
        int start = 0;
        for (int i = 0; i < n; i++) {
            charCnt[chars[i] - 'a']++;
            if (!ifVowel(chars[i])) {
                start = i + 1;
                left = start;
                clearAll(charCnt);
                continue;
            }
            while (ifVowelAll(charCnt)) {
                charCnt[chars[left++] - 'a']--;
            }
            ans += left - start;
        }
        return ans;
    }

    private boolean ifVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    private boolean ifVowelAll(char[] chars) {
        return chars[0] >= 1 && chars['e' - 'a'] >= 1 && chars['i' - 'a'] >= 1 && chars['o' - 'a'] >= 1 && chars['u' - 'a'] >= 1;
    }

    private void clearAll(char[] chars) {
        chars[0] = 0;
        chars['e' - 'a'] = 0;
        chars['i' - 'a'] = 0;
        chars['o' - 'a'] = 0;
        chars['u' - 'a'] = 0;
    }
}
