package com.kanako.no3491_3500.no3498;

public class Solution {
    public int reverseDegree(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
             int reverseIndex = 26 - (s.charAt(i) - 'a');
             res += reverseIndex * (i + 1);
        }
        return res;
    }
}
