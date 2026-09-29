package com.kanako.WeeklyCompetition2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        // TreeMap：key 自带有序，省掉每次 sorted()
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[nums.length];
        int index = 0;
        while (index < ans.length) {
            // 遍历时会 remove，先拷贝一份 key，避免 ConcurrentModificationException
            List<Integer> keys = new ArrayList<>(map.keySet());
            for (int k : keys) {
                ans[index++] = k;
                int count = map.get(k) - 1;
                if (count == 0) {
                    map.remove(k);
                } else {
                    map.put(k, count);
                }
            }
        }
        return ans;
    }
}
