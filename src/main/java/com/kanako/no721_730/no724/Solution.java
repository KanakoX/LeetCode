package com.kanako.no721_730.no724;

public class Solution {
    public int pivotIndex(int[] nums) {
        int len = nums.length;
        int[] sums = new int[len + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < len; i++) {
            if (sums[i] == (sums[len] - sums[i + 1])) return i;
        }
        return -1;
    }
}
