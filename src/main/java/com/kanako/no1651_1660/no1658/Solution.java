package com.kanako.no1651_1660.no1658;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int minOperations(int[] nums, int x) {
        if (nums[0] == x) return 1;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }

        int minStep = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= nums.length; i++) {
            map.put(x - sums[i], i);
        }
        for (int i = nums.length; i >= 1; i--) {
            int target = end(sums, i);
            if (map.containsKey(target) && map.get(target) + nums.length - i <= nums.length) {
                minStep = Math.min(minStep, map.get(target) + nums.length - i);
            }
        }
        map.keySet().forEach(i -> System.out.println(i + ": " + map.get(i)));
        return minStep == Integer.MAX_VALUE ? -1 : minStep;
    }

    private int end(int[] sums, int index) {
        return sums[sums.length - 1] - sums[index];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minOperations(new int[]{1,1}, 3));
    }
}
