package com.kanako.no1493;

public class Solution {
    public int longestSubarray(int[] nums) {
        int zeroCnt = 0;
        int n = nums.length;
        int maxLen = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) zeroCnt++;
            while (zeroCnt > 1) {
                if (nums[left++] == 0) zeroCnt--;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen - 1;
    }
}
