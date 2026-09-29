package com.kanako.no671_680.no673;

public class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] cnt = new int[n];
        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            len[i] = 1;
            cnt[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] >= nums[i]) {
                    continue;
                }
                if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    cnt[i] = cnt[j];
                } else if (len[j] + 1 == len[i]) {
                    cnt[i] += cnt[j];
                }
            }
            maxLen = Math.max(maxLen, len[i]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (len[i] == maxLen) {
                ans += cnt[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findNumberOfLIS(new int[]{1, 3, 5, 4, 7})); // 2
        System.out.println(s.findNumberOfLIS(new int[]{2, 2, 2, 2, 2})); // 5
        System.out.println(s.findNumberOfLIS(new int[]{3, 1, 2}));       // 1（你原方案会得到 2）
    }
}
