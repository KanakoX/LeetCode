package com.kanako.no68;

public class Solution {
    public int beautifulBouquet(int[] flowers, int cnt) {
        int n = flowers.length;
        int[] numCnt = new int[100001];
        int ans = 0;
        int left = 0;
        for (int i = 0; i < n; i++) {
            numCnt[flowers[i]]++;
            while (numCnt[flowers[i]] > cnt) {
                numCnt[flowers[left++]]--;
            }
            ans += i - left + 1;
        }
        return ans;
    }
}
