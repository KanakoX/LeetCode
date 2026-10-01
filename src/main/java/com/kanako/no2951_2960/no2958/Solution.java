package com.kanako.no2951_2960.no2958;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> numCnt = new HashMap<>();
        int left = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            numCnt.merge(nums[i], 1, Integer::sum);
            while (numCnt.get(nums[i]) > k) {
                numCnt.merge(nums[left++], -1, Integer::sum);
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }
}
