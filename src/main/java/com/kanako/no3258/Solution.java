package com.kanako.no3258;

public class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int n = s.length();
        int[] cnt = new int[2];
        int left = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            cnt[chars[i] - '0']++;
            while (cnt[0] > k && cnt[1] > k) {
                cnt[chars[left++] - '0']--;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
