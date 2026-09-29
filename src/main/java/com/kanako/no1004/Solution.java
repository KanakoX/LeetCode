package com.kanako.no1004;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int zeroCnt = 0;
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zeroCnt++;
            while (zeroCnt > k) {
                if (nums[left++] == 0) zeroCnt--;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
