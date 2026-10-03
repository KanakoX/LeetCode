package com.kanako.no2761_2770.no2762;

import java.util.TreeMap;

public class Solution {
    public long continuousSubarrays(int[] nums) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int n = nums.length;
        int left = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            map.merge(val, 1, Integer::sum);
            while (Math.abs(map.firstKey() - val) > 2 || Math.abs(map.lastKey() - val) > 2) {
                int leftVal = nums[left++];
                int count = map.get(leftVal);
                if (count == 1) map.remove(leftVal);
                else map.put(leftVal, count - 1);
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
