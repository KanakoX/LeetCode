package com.kanako.no3291_3300.no3298;

import java.util.Arrays;

public class Solution {
    public long validSubstringCount(String word1, String word2) {
        long ans = 0;
        int[] w2Cnt = new int[26];
        int[] w1Cnt = new int[26];
        int w2TypeCnt = 0;
        int w1CorrectCnt = 0;
        for (int i = 0; i < word2.length(); i++) {
            if (w2Cnt[word2.charAt(i) - 'a']++ == 0) {
                w2TypeCnt++;
            }
        }
        char[] chars = word1.toCharArray();
        int left = 0;
        for (char aChar : chars) {
            if (++w1Cnt[aChar - 'a'] == w2Cnt[aChar - 'a']) {
                w1CorrectCnt++;
            }
            while (w1CorrectCnt == w2TypeCnt) {
                char leftChar = chars[left++];
                if (--w1Cnt[leftChar - 'a'] < w2Cnt[leftChar - 'a']) {
                    w1CorrectCnt--;
                }
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.validSubstringCount("bcca", "abc"));
    }
}
