package com.kanako.no2531_2540.no2537;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        long ans = 0;
        long pairs = 0;
        int left = 0;
        for (int num : nums) {
            int cnt = map.getOrDefault(num, 0);
            map.put(num, cnt + 1);
            if (cnt > 0) pairs += cnt;
            while (pairs >= k) {
                int leftCnt = map.get(nums[left]);
                map.put(nums[left++], leftCnt - 1);
                pairs -= leftCnt - 1;
            }
            ans += left;
        }
        return ans;
    }
}

// 2 2 2
