package com.kanako.no3325;

public class Solution {
    public int numberOfSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int[] charCnt = new int[26];
        int n = s.length();
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            charCnt[chars[i] - 'a']++;
            while (charCnt[chars[i] - 'a'] == k) {
                charCnt[chars[left++] - 'a']--;
            }
            ans += left;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numberOfSubstrings("abacb", 2));
    }
}
