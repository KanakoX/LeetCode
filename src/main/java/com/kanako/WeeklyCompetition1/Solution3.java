package com.kanako.WeeklyCompetition1;

import java.util.Arrays;

/**
 * 最长合法子数组：和 % k == 0，或取反一个元素后和 % k == 0
 * 约束：n≤1e5, k≤3000 → O(nk)
 */
public class Solution3 {
    public int longestValidSubarray(int[] nums, int k) {
        int n = nums.length;
        int[] first = new int[k]; // pref[L]%k == r 的最小 L
        Arrays.fill(first, -1);
        first[0] = 0; // pref[0] = 0

        int[] maxIdx = new int[k]; // 2*nums[x]%k == v 的最大 x
        Arrays.fill(maxIdx, -1);

        int ans = 0;
        long pref = 0;
        for (int r = 0; r < n; r++) {
            pref += nums[r];
            int pr = (int) ((pref % k + k) % k); // pref[r+1] % k

            // 先纳入 x=r，再查取反情况
            int vr = (int) (((2L * nums[r]) % k + k) % k);
            maxIdx[vr] = r;

            // ① 不取反
            if (first[pr] != -1) {
                ans = Math.max(ans, r - first[pr] + 1);
            }

            // ② 取反：枚举 v = 2*nums[x]%k
            for (int v = 0; v < k; v++) {
                if (maxIdx[v] == -1) {
                    continue;
                }
                int l0 = first[(pr - v + k) % k];
                if (l0 != -1 && maxIdx[v] >= l0) {
                    ans = Math.max(ans, r - l0 + 1);
                }
            }

            // 先查后记：登记 pref[r+1]
            if (first[pr] == -1) {
                first[pr] = r + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.longestValidSubarray(new int[]{4, 1, 2}, 3)); // 3
        System.out.println(s.longestValidSubarray(new int[]{5, 3, 4}, 7)); // 2
    }
}
