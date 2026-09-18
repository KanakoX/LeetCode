package com.kanako.no3621_3630.no3622;

public class Solution {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        for (int x = n; x > 0; x /= 10) {
            int d = x % 10;
            sum += d;
            product *= d;
        }
        return n % (sum + product) == 0;
    }
}
