package com.kanako.no71_80.no76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        Map<Character, Integer> tCharCntMap = new HashMap<>();
        int[] charCnt = new int[128];
        for (int i = 0; i < n; i++) {
            tCharCntMap.put(t.charAt(i), tCharCntMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int minLen = Integer.MAX_VALUE;
        int correct = 0;
        int left = 0;
        int[] store = new int[2];
        for (int i = 0; i < m; i++) {
            char currentChar = s.charAt(i);
            if (tCharCntMap.containsKey(currentChar)) {
                if (++charCnt[currentChar] == tCharCntMap.get(currentChar)) {
                    correct++;
                }
                while (correct == tCharCntMap.size()) {
                    if (i - left + 1 < minLen) {
                        minLen = i - left + 1;
                        store[0] = left;
                        store[1] = i;
                    }
                    char leftChar = s.charAt(left++);
                    if (tCharCntMap.containsKey(leftChar)) {
                        if (charCnt[leftChar]-- == tCharCntMap.get(leftChar)) {
                            correct--;
                        }
                    }
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(store[0], store[1] + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}

// ADOBECODEBANC ABC
// ADOBEBODCBANC ABC
