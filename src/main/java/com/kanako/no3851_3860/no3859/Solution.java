package com.kanako.no3851_3860.no3859;

public class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        int[] cnt1 = new int[100001];
        int[] cnt2 = new int[100001];
        int left1 = 0, left2 = 0;
        int typeCnt1 = 0, typeCnt2 = 0;
        int match1 = 0, match2 = 0;
        long ans = 0;
        for (int num : nums) {
            if (cnt1[num]++ == 0) {
                typeCnt1++;
            }
            if (cnt1[num] == m) {
                match1++;
            }
            while (match1 >= k && typeCnt1 >= k) {
                if (--cnt1[nums[left1]] == 0) {
                    typeCnt1--;
                }
                if (cnt1[nums[left1]] == m - 1) {
                    match1--;
                }
                left1++;
            }
            ans += left1;

            if (cnt2[num]++ == 0) {
                typeCnt2++;
            }
            if (cnt2[num] == m) {
                match2++;
            }
            while (match2 >= k && typeCnt2 >= k + 1) {
                if (--cnt2[nums[left2]] == 0) {
                    typeCnt2--;
                }
                if (cnt2[nums[left2]] == m - 1) {
                    match2--;
                }
                left2++;
            }
            ans -= left2;
        }
        return ans;
    }
}
