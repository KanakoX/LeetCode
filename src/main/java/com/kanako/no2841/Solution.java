package com.kanako.no2841;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public long maxSum(List<Integer> nums, int m, int k) {
        int n = nums.size();
        long result = 0;
        long sum = 0;
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int num = nums.get(i);
            sum += num;
            numMap.put(num, numMap.getOrDefault(num, 0) + 1);
            int left = i - k + 1;
            if (left < 0) continue;

            if (numMap.size() >= m) result = Math.max(result, sum);
            int leftNum = nums.get(left);
            int leftNumCnt = numMap.getOrDefault(leftNum, 0) - 1;
            sum -= leftNum;
            if (leftNumCnt <= 0) {
                numMap.remove(leftNum);
            } else {
                numMap.put(leftNum, leftNumCnt);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSum(List.of(1, 2, 2), 2, 2));
    }
}
