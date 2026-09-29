package com.kanako.no2090;

public class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n];
        long currentSum = 0;
        int index = 0;
        while (index < n + k) {
            int mid = index - k;
            int left = index - 2 * k;
            if (index < n) {
                currentSum += nums[index];
            }
            if (left < 0 || index >= n) {
                if (mid >= 0) result[mid] = -1;
                index++;
                continue;
            }
            result[mid] = (int) (currentSum / (k * 2 + 1));
            currentSum -= nums[left];
            index++;
        }
        return result;
    }
}

// 0 1 2 3 4 5 6 7 k=2 n=5
