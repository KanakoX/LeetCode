package com.kanako.no344;

public class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        int mid = n / 2;
        for (int i = 0; i < mid; i++) {
            int right = n - i - 1;
            char temp = s[right];
            s[right] = s[i];
            s[i] = temp;
        }
    }
}
