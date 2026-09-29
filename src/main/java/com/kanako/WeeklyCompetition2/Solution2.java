package com.kanako.WeeklyCompetition2;

import java.util.HashMap;
import java.util.Map;

public class Solution2 {
    public int maxEqualAdjacentPairs(int[] nums) {
        int count = 0;
        Map<Long, Integer> countMap = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int a = nums[i], b = nums[i + 1];
            if (a == b) {
                count++;
                continue;
            }
            int lower = Math.min(a, b), higher = Math.max(a, b);
            long key = ((long) lower << 32) | (higher & 0xffffffffL);
            countMap.merge(key, 1, Integer::sum);
        }
        int count2 = 0;
        for (int c : countMap.values()) {
            count2 = Math.max(count2, c);
        }
        return count + count2;
    }
}
