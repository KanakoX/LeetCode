package com.kanako.no2791_2800.no2799;

public class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int type = 0;
        int[] typeCnt = new int[1001];

        int[] cnt = new int[1001];
        int currentCnt = 0;
        int ans = 0;
        int left = 0;
        for (int num : nums) {
            if (typeCnt[num] == 0) {
                type++;
                typeCnt[num]++;
            }
        }
        for (int num : nums) {
            if (cnt[num]++ == 0) {
                currentCnt++;
            }
            while (currentCnt == type) {
                if (--cnt[nums[left++]] == 0) {
                    currentCnt--;
                }
            }
            ans += left;
        }
        return ans;
    }
}
