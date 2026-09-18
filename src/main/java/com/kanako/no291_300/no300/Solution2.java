package com.kanako.no291_300.no300;

import java.util.Arrays;

public class Solution2 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int index = 0;
        int[] dp = new int[n];
        dp[index] = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] > dp[index]) {
                dp[++index] = nums[i];
                System.out.println(Arrays.toString(dp));
            } else {
                int left = 0, right = index, pos = 0;
                while (left <= right) {
                    int mid = left + ((right - left) >> 1);
                    if (dp[mid] < nums[i]) {
                        left = mid + 1;
                        pos = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
                dp[pos] = nums[i];
            }
        }
        return index + 1;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.lengthOfLIS(new int[]{0,1,0,3,2,3}));
    }
}
