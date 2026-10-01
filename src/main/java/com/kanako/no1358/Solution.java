package com.kanako.no1358;

public class Solution {
    public int numberOfSubstrings(String s) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] cnt = new int[3];
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            cnt[chars[i] - 'a']++;
            while (cnt[0] > 0 && cnt[1] > 0 && cnt[2] > 0) {
                cnt[chars[left++] - 'a']--;
            }
            ans += left;
        }
        return ans;
    }
}
