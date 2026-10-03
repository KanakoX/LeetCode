package com.kanako.no3301_3310.no3306;

public class Solution {
    public long countOfSubstrings(String word, int k) {
        long ans = 0;
        char[] chars = word.toCharArray();
        int[] cnt1 = new int[6];
        int[] cnt2 = new int[6];
        int vowelsCnt1 = 0;
        int vowelsCnt2 = 0;
        int left1 = 0, left2 = 0;
        for (char aChar : chars) {
            if (cnt1[format(aChar)]++ == 0 && ifVowels(aChar)) {
                vowelsCnt1++;
            }
            while (vowelsCnt1 == 5 && cnt1[0] >= k) {
                if (--cnt1[format(chars[left1])] <= 0 && ifVowels(chars[left1])) {
                    vowelsCnt1--;
                }
                left1++;
            }
            ans += left1;

            if (cnt2[format(aChar)]++ == 0 && ifVowels(aChar)) {
                vowelsCnt2++;
            }
            while (vowelsCnt2 == 5 && cnt2[0] >= k + 1) {
                if (--cnt2[format(chars[left2])] <= 0 && ifVowels(chars[left2])) {
                    vowelsCnt2--;
                }
                left2++;
            }
            ans -= left2;
        }
        return ans;
    }

    private boolean ifVowels(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    private int format(char c) {
        int res = 0;
        switch (c) {
            case 'a' -> res = 1;
            case 'e' -> res = 2;
            case 'i' -> res = 3;
            case 'o' -> res = 4;
            case 'u' -> res = 5;
        }
        return res;
    }
}
