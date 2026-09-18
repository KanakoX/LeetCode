package com.kanako.no3111_3120.no3116;

public class Solution2 {
    public long findKthSmallest(int[] coins, int k) {
        long min = coins[0];
        for (int c : coins) {
            min = Math.min(min, c);
        }
        long left = min;
        long right = min * k;
        while (left < right) {
            long mid = left + (right - left) / 2;
            if (count(coins, mid) >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private long count(int[] coins, long x) {
        int n = coins.length;
        long ans = 0;
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm_val = 1;
            int bits = 0;
            boolean overflow = false;
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) == 0) {
                    continue;
                }
                bits++;
                lcm_val = lcm(lcm_val, coins[i]);
                if (lcm_val > x) {
                    overflow = true;
                    break;
                }
            }
            if (overflow) {
                continue;
            }
            long cnt = x / lcm_val;
            if (bits % 2 == 1) {
                ans += cnt;
            } else {
                ans -= cnt;
            }
        }
        return ans;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.findKthSmallest(new int[]{3, 6, 9}, 3)); // 9
        System.out.println(solution.findKthSmallest(new int[]{5, 2}, 7));    // 12
    }
}
