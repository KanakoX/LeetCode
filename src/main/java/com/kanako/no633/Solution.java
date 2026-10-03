package com.kanako.no633;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int right = (int) Math.sqrt(c);
        int left = 1;
        while (left < right) {
            if (left * left + right * right == c) return true;
            if (left * left + right * right > c) right--;
            else left++;
        }
        return false;
    }
}
