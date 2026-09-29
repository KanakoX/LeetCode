package com.kanako.no2461;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long result = 0;
        long sum = 0;
        Map<Integer, Integer> numCntMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int curNum = nums[i];
            sum += curNum;
            numCntMap.put(curNum, numCntMap.getOrDefault(curNum, 0) + 1);
            int left = i - k + 1;
            if (left < 0) continue;
            if (numCntMap.size() == k) result = Math.max(result, sum);
            int leftNum = nums[left];
            int leftNumCnt = numCntMap.getOrDefault(leftNum, 0) - 1;
            sum -= leftNum;
            if (leftNumCnt <= 0) {
                numCntMap.remove(leftNum);
            } else {
                numCntMap.put(leftNum, leftNumCnt);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumSubarraySum(new int[]{1,5,4,2,9,9,9}, 3));
    }
}
