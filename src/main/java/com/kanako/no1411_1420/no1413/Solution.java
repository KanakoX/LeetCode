package com.kanako.no1411_1420.no1413;

import java.util.Arrays;

public class Solution {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
            min = Math.min(min, sums[i + 1]);
        }
        return Math.max((1 - min), 1);
    }
}
