package com.kanako.no3634;

import java.util.Arrays;

public class Solution {
    public int minRemoval(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            int curNum = nums[i];
            while ((long) nums[left] * k < (long) curNum) {
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return n - maxLen;
    }
}
