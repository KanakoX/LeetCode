package com.kanako.WeeklyCompetition2;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长子数组：不存在不同下标 i,j,k 使 nums[i]+nums[j]=nums[k]
 */
public class Solution3 {
    public int maxSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }

        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, ans = 0, odd = 0;

        for (int right = 0; right < n; right++) {
            add(freq, nums[right]);
            if ((nums[right] & 1) == 1) {
                odd++;
            }

            while (left <= right && !valid(freq, odd, right - left + 1)) {
                if ((nums[left] & 1) == 1) {
                    odd--;
                }
                remove(freq, nums[left]);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    private void add(Map<Integer, Integer> freq, int x) {
        freq.put(x, freq.getOrDefault(x, 0) + 1);
    }

    private void remove(Map<Integer, Integer> freq, int x) {
        int c = freq.get(x);
        if (c == 1) {
            freq.remove(x);
        } else {
            freq.put(x, c - 1);
        }
    }

    private boolean valid(Map<Integer, Integer> freq, int odd, int len) {
        if (len <= 2) {
            return true;
        }
        // 全奇数：两数之和为偶数，不可能等于窗口内奇数
        if (odd == len) {
            return true;
        }
        // 2*min > max：任意两数之和都大于 max
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int v : freq.keySet()) {
            min = Math.min(min, v);
            max = Math.max(max, v);
        }
        if (2L * min > max) {
            return true;
        }
        // 否则检查是否存在 a+b=c
        for (int c : freq.keySet()) {
            if (canTwoSum(freq, c)) {
                return false;
            }
        }
        return true;
    }

    /** 是否存在两个不同下标，值之和为 c */
    private boolean canTwoSum(Map<Integer, Integer> freq, int c) {
        for (var e : freq.entrySet()) {
            int a = e.getKey();
            int b = c - a;
            if (a == b) {
                if (e.getValue() >= 2) {
                    return true;
                }
            } else if (freq.containsKey(b)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.maxSubarray(new int[]{2, 3, 5, 3, 2, 1})); // 3
        System.out.println(s.maxSubarray(new int[]{1, 1, 1, 1}));       // 4
        System.out.println(s.maxSubarray(new int[]{1, 2, 3}));          // 2
    }
}
