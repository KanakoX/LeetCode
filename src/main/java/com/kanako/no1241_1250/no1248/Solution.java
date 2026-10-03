package com.kanako.no1241_1250.no1248;

public class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;
        int left1 = 0, left2 = 0;
        int cnt1 = 0, cnt2 = 0;
        for (int num : nums) {
            if (num % 2 != 0) cnt1++;
            if (num % 2 != 0) cnt2++;

            while (cnt1 >= k) {
                if (nums[left1++] % 2 != 0) cnt1--;
            }
            ans += left1;
            while (cnt2 > k) {
                if (nums[left2++] % 2 != 0) cnt2--;
            }
            ans -= left2;
        }
        return ans;
    }
}
