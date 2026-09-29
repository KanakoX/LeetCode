package com.kanako.no1668;

public class Solution {
    public int maxRepeating(String sequence, String word) {
        String pattern = word;
        int count = 0;
        while (sequence.contains(pattern)) {
            count++;
            pattern += word;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }
}
